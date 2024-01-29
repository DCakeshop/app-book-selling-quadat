package com.example.appbookselling_quadat.controller;

import com.example.appbookselling_quadat.beans.response.UserResponse;
import com.example.appbookselling_quadat.entity.User;
import com.example.appbookselling_quadat.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/all")
    public List<UserResponse> getAllUser(){
        return userService.getUserList();
    }

    @GetMapping("/{id}")
    public UserResponse getDetailUser(@PathVariable int id){
        return userService.getDetailUser(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody User user){
        userService.createUser(user);
    }

    @PutMapping("/edit")
    public void update(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }
}
