package com.todomanagement.controller;


import com.todomanagement.dto.JwtAuthResponse;
import com.todomanagement.dto.LoginDto;
import com.todomanagement.dto.RegisterDto;
import com.todomanagement.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        JwtAuthResponse  jwtAuthResponse = authService.login(loginDto);


        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

}
