package com.example.appbookselling_quadat.controller;

import com.example.appbookselling_quadat.beans.response.UserTypeResponse;
import com.example.appbookselling_quadat.entity.UserType;
import com.example.appbookselling_quadat.service.UserTypeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usertype")
@AllArgsConstructor
public class UserTypeController {
    private UserTypeService userTypeService;

    @GetMapping("/all")
    public List<UserTypeResponse> getAllUserType(){
        return userTypeService.getUserTypeList();
    }

    @GetMapping("/{id}")
    public UserTypeResponse getDetailUserTypeResponse(@PathVariable int id){
        return userTypeService.getDetailUserType(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody UserType userType){
        userTypeService.createUserType(userType);
    }

    @PutMapping("/edit")
    public void update(@RequestBody UserType userType){
        userTypeService.updateUserType(userType);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userTypeService.delete(id);
    }
}