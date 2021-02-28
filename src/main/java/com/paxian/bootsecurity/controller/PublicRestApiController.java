package com.paxian.bootsecurity.controller;

import com.paxian.bootsecurity.db.UserRepository;
import com.paxian.bootsecurity.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<User> getUsers(){
        return this.userRepository.findAll();
    }

    // Available to managers
    @GetMapping("management/reports")
    public String getManager(){
        return "{\"" + "message" + "\":\"" + "Some management report data" + "\"}";
    }

    // Available to ROLE_ADMIN
    @GetMapping("admin/users")
    public String getAdmin(){
        return "{\"" + "message" + "\":\"" + "API for admin users" + "\"}";
    }
}
