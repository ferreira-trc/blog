package org.rumos.blog.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.rumos.blog.model.Exceptions.ResourceNotFoundException;
import org.rumos.blog.model.Exceptions.RoleNotFoundException;
import org.rumos.blog.model.dtos.entities.user.UserDTOToRegister;
import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;
import org.rumos.blog.model.dtos.entities.user.UserDTOToUpdate;
import org.rumos.blog.model.dtos.maps.interfaces.UserMapDTO;
import org.rumos.blog.model.entities.User;
import org.rumos.blog.model.enums.Role;
import org.rumos.blog.repositories.UserRepository;
import org.rumos.blog.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapDTO userMapDTO;
   
    public List<UserDTOToShow> findAll() {
        List<User> list = userRepository.findAll();
        List<UserDTOToShow> listDTOs = new ArrayList<>();

        for (User user : list) {
            listDTOs.add(userMapDTO.convertToDTO(user));
        }

        return listDTOs;
    }

    public UserDTOToShow findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            return null;
        }

        UserDTOToShow userDTO = userMapDTO.convertToDTO(user.get());
        return userDTO;
    }

    @Override
    public UserDTOToShow findByUserName(String userName) {
        Optional<User> user = userRepository.findByUserName(userName);

        if (user.isEmpty()) {
            return null;
        }
        
        UserDTOToShow userDTO = userMapDTO.convertToDTO(user.get());
        return userDTO;
    }

    public UserDTOToShow register(UserDTOToRegister userDTO) { 
        User userToSave = userMapDTO.convertToClass(userDTO);

        if (userRepository.findByUserName(userDTO.userName()).isPresent()) {
            return null;
        }
        
        String encryptedPassword = new BCryptPasswordEncoder().encode(userDTO.password());
        userToSave.setPassword(encryptedPassword);
        userToSave.setRole(Role.USER);

        User userToReturn = userRepository.save(userToSave);
                
        return userMapDTO.convertToDTO(userToReturn);
    }

    public UserDTOToShow update(Long userId, UserDTOToUpdate userUpdated) {
        User userToUpdate = userRepository.getReferenceById(userId);
        User userToSave = userMapDTO.convertToClass(userUpdated, userToUpdate);
        User userToReturn = userRepository.save(userToSave);
        UserDTOToShow userDTO = userMapDTO.convertToDTO(userToReturn);
        return userDTO;
    }  
    
    public UserDTOToShow updateUserRole(Long userId, String newRole) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));         

        switch (newRole.toLowerCase()) {
            case "admin":
                user.setRole(Role.ADMIN);
                break;

            case "user":
                user.setRole(Role.USER);
                break;
        
            default:
                throw new RoleNotFoundException("Role not found");                
        }        
        
        User updatedUser = userRepository.save(user);
        UserDTOToShow userDTO = userMapDTO.convertToDTO(updatedUser);
        return userDTO; 
    }

    public UserDTOToShow delete(Long id) {
        Optional<User> userToDelete = userRepository.findById(id);        
        userRepository.deleteById(id);        

        UserDTOToShow userDeleted = userMapDTO.convertToDTO(userToDelete.get());
        return userDeleted;        
    }
   

}
