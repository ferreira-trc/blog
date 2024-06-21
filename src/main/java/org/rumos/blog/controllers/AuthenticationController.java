package org.rumos.blog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.rumos.blog.model.dtos.entities.AuthenticatioDTO;
import org.rumos.blog.model.dtos.entities.LoginResponseDTO;
import org.rumos.blog.model.dtos.entities.user.UserDTOToRegister;
import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;
import org.rumos.blog.model.entities.User;
import org.rumos.blog.services.implementations.TokenService;
import org.rumos.blog.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;
    
    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody AuthenticatioDTO entity) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(entity.login(), entity.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.genereteToken((User) auth.getPrincipal());

        return ResponseEntity.ok().body(new LoginResponseDTO(token));
    }
    
    @PostMapping(value = "/register")
    public ResponseEntity<UserDTOToShow> register(@Valid @RequestBody UserDTOToRegister entity) {
        UserDTOToShow userRegisted = userService.register(entity);        
        return ResponseEntity.ok().body(userRegisted);
    }
    
}
