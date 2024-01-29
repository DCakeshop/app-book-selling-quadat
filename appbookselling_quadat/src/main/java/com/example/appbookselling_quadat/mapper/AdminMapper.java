package com.example.appbookselling_quadat.mapper;

import com.example.appbookselling_quadat.beans.response.AdminResponse;
import com.example.appbookselling_quadat.entity.Admin;

public class AdminMapper {
    public static AdminResponse convertToResponse(Admin admin){
        AdminResponse adminResponse = new AdminResponse();
        adminResponse.setUserId(admin.getUserId());
        return adminResponse;
    }
}
