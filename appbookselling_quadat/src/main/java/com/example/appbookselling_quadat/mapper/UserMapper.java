package com.example.appbookselling_quadat.mapper;

import com.example.appbookselling_quadat.beans.response.UserResponse;
import com.example.appbookselling_quadat.entity.User;

public class UserMapper {
    public static UserResponse convertToResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setUserName(user.getUserName());
        userResponse.setPassword(user.getPassword());
        userResponse.setEmail(user.getEmail());
        userResponse.setUserTypeId(user.getUserTypeId());
        return userResponse;
    }
}
