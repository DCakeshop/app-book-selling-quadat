package com.example.appbookselling_quadat.service;

import com.example.appbookselling_quadat.beans.response.UserTypeResponse;
import com.example.appbookselling_quadat.entity.UserType;
import com.example.appbookselling_quadat.exception.NotFoundException;

import java.util.List;

public interface UserTypeService {
    List<UserTypeResponse> getUserTypeList();
    UserTypeResponse getDetailUserType(int id) throws NotFoundException;
    void createUserType(UserType obj);
    void updateUserType(UserType obj);
    void delete(int id);
}
