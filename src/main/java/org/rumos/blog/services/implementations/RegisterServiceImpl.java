package org.rumos.blog.services.implementations;

import org.rumos.blog.model.dtos.entities.UserPersonDTO;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToRegister;
import org.rumos.blog.model.dtos.entities.user.UserDTOToRegister;
import org.rumos.blog.model.dtos.maps.interfaces.PersonMapDTO;
import org.rumos.blog.model.dtos.maps.interfaces.UserMapDTO;
import org.rumos.blog.model.dtos.maps.interfaces.UserPersonMapDTO;
import org.rumos.blog.model.entities.Person;
import org.rumos.blog.model.entities.User;
import org.rumos.blog.model.enums.Role;
import org.rumos.blog.repositories.PersonRepository;
import org.rumos.blog.repositories.UserRepository;
import org.rumos.blog.services.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserMapDTO userMapDTO;

    @Autowired
    private PersonMapDTO personMapDTO;

    @Autowired
    private UserPersonMapDTO userPersonMapDTO;

    @Override
    public UserPersonDTO register(UserDTOToRegister userDTO, PersonDTOToRegister personDTO) { 
        User userToSave = userMapDTO.convertToClass(userDTO);
        Person personToSave = personMapDTO.convertToClass(personDTO);
        

        if (personRepository.findByEmail(personDTO.email()).isPresent()) {
            return null;
        }

        if (userRepository.findByUserName(userDTO.userName()).isPresent()) {
            return null;
        }
               
        String encryptedPassword = new BCryptPasswordEncoder().encode(userDTO.password());
        userToSave.setPassword(encryptedPassword);
        userToSave.setRole(Role.USER);

        Person personToReturn = personRepository.save(personToSave);
        User userToReturn = userRepository.save(userToSave);
                
        return userPersonMapDTO.convertToDTO(userToReturn, personToReturn);
    }
}
