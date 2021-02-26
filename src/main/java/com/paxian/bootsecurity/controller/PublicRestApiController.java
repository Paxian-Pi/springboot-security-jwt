package com.paxian.bootsecurity.controller;

import com.paxian.bootsecurity.security.JwtConstants;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.paxian.bootsecurity.db.UserRepository;
import com.paxian.bootsecurity.model.User;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class PublicRestApiController {
    public UserRepository userRepository;

    public PublicRestApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Available to all authenticated users
    @GetMapping("all")
    public String test1(){
        return "{\"" + "message" + "\":\"" + "API for all users" + "\"}";
    }

    // Available to managers
    @GetMapping("management/reports")
    public String reports(){
        return "{\"" + "message" + "\":\"" + "Some management report data" + "\"}";
    }

    // Available to ROLE_ADMIN
    @GetMapping("admin/users")
    public List<User> users(){
        return this.userRepository.findAll();
    }
}
