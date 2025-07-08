package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final String TEST_USER = "test";
    private static final String TEST_PW = "1234";

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        if(TEST_USER.equals(request.getUsername()) && TEST_PW.equals(request.getPassword())){
            String token = JwtUtil.generateToken(request.getUsername());
            return token;
        }
        return "Login Failed";
    }
}
