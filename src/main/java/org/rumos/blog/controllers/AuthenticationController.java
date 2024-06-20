package org.rumos.blog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.rumos.blog.model.dtos.entities.AuthenticatioDTO;
import org.rumos.blog.model.dtos.entities.LoginResponseDTO;
import org.rumos.blog.model.dtos.entities.RegisterDTO;
import org.rumos.blog.model.entities.User;
import org.rumos.blog.repositories.UserRepository;
import org.rumos.blog.services.implementations.TokenService;
import org.rumos.blog.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;
    
    @PostMapping(value = "/login")
    public ResponseEntity login(@Valid @RequestBody AuthenticatioDTO entity) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(entity.login(), entity.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.genereteToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
    
    @PostMapping(value = "/register")
    public ResponseEntity register(@Valid @RequestBody RegisterDTO entity) {
        if (userRepository.findByEmail(entity.login()) != null) {
            return ResponseEntity.badRequest().build();
        }
        
        String encryptedPassword = new BCryptPasswordEncoder().encode(entity.password());
        User user = new User(null, entity.login(), entity.login(), encryptedPassword, entity.role(), null);

        this.userRepository.save(user);
        
        return ResponseEntity.ok().build();
    }
    
}
