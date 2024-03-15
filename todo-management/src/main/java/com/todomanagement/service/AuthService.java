package com.todomanagement.service;

import com.todomanagement.dto.JwtAuthResponse;
import com.todomanagement.dto.LoginDto;
import com.todomanagement.dto.RegisterDto;
import org.apache.catalina.webresources.JarWarResource;

public interface AuthService {
    String register(RegisterDto registerDto);
    JwtAuthResponse login(LoginDto loginDto);
}
