package com.example.appbookselling_quadat.service;

import com.example.appbookselling_quadat.beans.response.AdminResponse;
import com.example.appbookselling_quadat.entity.Admin;
import com.example.appbookselling_quadat.exception.NotFoundException;

import java.util.List;

public interface AdminService {
    List<AdminResponse> getAdminList();
    AdminResponse getDetailAdmin(int id) throws NotFoundException;
    void createAdmin(Admin obj);
    void updateAdmin(Admin obj);
    void delete(int id);
}
