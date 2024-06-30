package org.rumos.blog.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.rumos.blog.model.dtos.entities.AuthenticatioDTO;
import org.rumos.blog.model.dtos.entities.LoginResponseDTO;
import org.rumos.blog.model.dtos.entities.RegisterDTO;
import org.rumos.blog.model.dtos.entities.UserPersonDTO;
import org.rumos.blog.model.entities.User;
import org.rumos.blog.services.implementations.TokenService;
import org.rumos.blog.services.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Controller responsible for authentication and user registration operations.
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private TokenService tokenService;
    
    /**
     * Endpoint for user authentication.
     *
     * @param entity DTO containing user authentication credentials
     * @return ResponseEntity containing login information, including JWT token
     */
    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody AuthenticatioDTO entity) {
        // Creating authentication token based on provided credentials
        var userNamePassword = new UsernamePasswordAuthenticationToken(entity.login(), entity.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        // Getting authenticated user
        User authUser = (User) auth.getPrincipal();
        
        // Generating JWT token for authenticated user
        String token = tokenService.genereteToken(authUser);

        // Returning response containing user ID, associated person ID, and JWT token
        return ResponseEntity.ok().body(new LoginResponseDTO(authUser.getId(), authUser.getPerson().getId(), token));
    }
    
    /**
     * Endpoint for user registration.
     *
     * @param entity DTO containing user registration data
     * @return ResponseEntity containing data of the registered user
     */
    @PostMapping(value = "/register")
    public ResponseEntity<UserPersonDTO> register(@Valid @RequestBody RegisterDTO entity) {
        // Registering the user and obtaining data of the registered user
        UserPersonDTO userRegistered = registerService.register(entity.userDTO(), entity.personDTO());        
        return ResponseEntity.ok().body(userRegistered);
    }
}


