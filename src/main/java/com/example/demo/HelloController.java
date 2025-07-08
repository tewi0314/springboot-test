package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public HelloResponse hello() {
        return new HelloResponse("Hello, JSON!", 123);
    }

    @PostMapping("/hello")
    public HelloResponse helloPost(@RequestBody HelloRequest request) {
        String message = "Hello, " + request.getName() + "!";
        int count = request.getAge()*2;

        return new HelloResponse(message, count);
    }
}
