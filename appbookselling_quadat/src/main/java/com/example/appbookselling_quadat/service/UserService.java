package com.example.appbookselling_quadat.service;

import com.example.appbookselling_quadat.beans.response.UserResponse;
import com.example.appbookselling_quadat.entity.User;
import com.example.appbookselling_quadat.exception.NotFoundException;

import java.util.List;

public interface UserService {
    List<UserResponse> getUserList();
    UserResponse getDetailUser(int id) throws NotFoundException;
    void createUser(User obj);
    void updateUser(User obj);
    void delete(int id);
}
