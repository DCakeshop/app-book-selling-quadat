package com.example.appbookselling_quadat.mapper;

import com.example.appbookselling_quadat.beans.response.UserTypeResponse;
import com.example.appbookselling_quadat.entity.UserType;

public class UserTypeMapper {
    public static UserTypeResponse convertToResponse(UserType userType){
        UserTypeResponse userTypeResponse = new UserTypeResponse();
        userTypeResponse.setTypeName(userType.getTypeName());
        return userTypeResponse;
    }
}
