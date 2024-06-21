package org.rumos.blog.services.implementations;

import org.rumos.blog.model.entities.User;
import org.rumos.blog.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService{

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationService.class);
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Attempting to load user by email: " + username);
        UserDetails user = userRepository.findByUserName(username).get();
        if (user == null) {
            logger.error("User not found with email: " + username);
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        logger.info("User found: " + user.getUsername());
        return user;
    }

}
