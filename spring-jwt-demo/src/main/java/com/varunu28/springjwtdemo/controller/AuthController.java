package com.varunu28.springjwtdemo.controller;

import com.varunu28.springjwtdemo.dto.LoginRequest;
import com.varunu28.springjwtdemo.dto.SignupRequest;
import com.varunu28.springjwtdemo.security.CustomUserDetailsService;
import com.varunu28.springjwtdemo.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;

    public AuthController(
        AuthenticationManager authenticationManager,
        JwtUtil jwtUtil,
        CustomUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        String token = jwtUtil.generateToken(authentication.getName());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody SignupRequest signupRequest) {
        boolean isRegistered = userDetailsService.registerUser(signupRequest.username(), signupRequest.password());
        if (isRegistered) {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signupRequest.username(), signupRequest.password()));
            String token = jwtUtil.generateToken(authentication.getName());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(400).body("User already exists");
        }
    }
}
