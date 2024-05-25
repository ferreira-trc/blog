package org.rumos.blog.services;

import java.util.List;
import java.util.Optional;

import org.rumos.blog.model.Post;
import org.rumos.blog.model.User;
import org.rumos.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> person = userRepository.findById(id);
        return person.get();
    }

    public User add(User user) {        
        return userRepository.save(user);
    }

     public User update(Long postId, User userUpdated) {
        User postToUpdate = userRepository.getReferenceById(postId);
        updateDate(postToUpdate, userUpdated);
        return userRepository.save(postToUpdate);
    }

    private void updateDate(User userToUpdate, User userUpdated) {        
        userToUpdate.setUserName(userUpdated.getUserName());
        userToUpdate.setPassword(userUpdated.getPassword());
        userToUpdate.setRole(userUpdated.getRole());       
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
