package com.speedy.resources;

import java.net.URI;
import java.util.Collections;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.speedy.domain.Role;
import com.speedy.domain.User;
import com.speedy.enuns.RoleName;
import com.speedy.exception.AppException;
import com.speedy.payload.ApiResponse;
import com.speedy.payload.JwtAuthenticationResponse;
import com.speedy.payload.LoginRequest;
import com.speedy.payload.SignUpRequest;
import com.speedy.repositories.RoleRepository;
import com.speedy.repositories.UserRepository;
import com.speedy.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthResource {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse(jwt);
        
        User user = null;
        
        if (jwtAuthenticationResponse.getAccessToken() != null && !jwtAuthenticationResponse.getAccessToken().isEmpty()) {
        	Optional<User> userFound = this.userRepository.findByUsernameOrEmail(loginRequest.getUsernameOrEmail(), loginRequest.getUsernameOrEmail());
        	if (userFound.isPresent()) {
        		user = userFound.get();
        		user.setToken(jwtAuthenticationResponse.getAccessToken());
        		user = this.userRepository.saveAndFlush(user);
        	}
        }
        
        return ResponseEntity.ok(user);
    }

    
    @PostMapping(value = "/signup", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

        user.setPassword((passwordEncoder).encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}
