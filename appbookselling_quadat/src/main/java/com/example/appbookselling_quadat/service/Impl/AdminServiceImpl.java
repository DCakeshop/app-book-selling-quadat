package com.example.appbookselling_quadat.service.Impl;

import com.example.appbookselling_quadat.beans.response.AdminResponse;
import com.example.appbookselling_quadat.entity.Admin;
import com.example.appbookselling_quadat.exception.NotFoundException;
import com.example.appbookselling_quadat.mapper.AdminMapper;
import com.example.appbookselling_quadat.repository.AdminRepository;
import com.example.appbookselling_quadat.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;
    @Override
    public List<AdminResponse> getAdminList() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream().map(AdminMapper::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AdminResponse getDetailAdmin(int id) throws NotFoundException {
        Admin admin = adminRepository.findAdminById(id);
        if(Objects.isNull(admin)){
            throw new NotFoundException("Not Found Object in Database");
        }
        return AdminMapper.convertToResponse(admin);
    }

    @Override
    public void createAdmin(Admin obj) {
        adminRepository.save(obj);
    }

    @Override
    public void updateAdmin(Admin obj) {
        adminRepository.save(obj);
    }

    @Override
    public void delete(int id) {
        Admin admin = adminRepository.findAdminById(id);
        if(Objects.isNull(admin)){
            throw new NotFoundException("Not Found Object in Database");
        }
        else {
            adminRepository.delete(admin);
        }
    }
}
