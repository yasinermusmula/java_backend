package com.example.ecommerce.controller;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/")
    public List<User> findAll(){
        return userService.findAll();
    }


    @GetMapping("/{id}")
    public User getById(@PathVariable long id){
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable long id){
        return userService.delete(id);
    }
}
