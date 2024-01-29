package com.example.appbookselling_quadat.controller;

import com.example.appbookselling_quadat.beans.response.AdminResponse;
import com.example.appbookselling_quadat.entity.Admin;
import com.example.appbookselling_quadat.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
public class AdminController {
    private AdminService adminService;

    @GetMapping("/all")
    public List<AdminResponse> getAllAdmin(){
        return adminService.getAdminList();
    }

    @GetMapping("/{id}")
    public AdminResponse getDetailAdmin(@PathVariable int id){
        return adminService.getDetailAdmin(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Admin admin){
        adminService.createAdmin(admin);
    }

    @PutMapping("/edit")
    public void update(@RequestBody Admin admin){
        adminService.updateAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        adminService.delete(id);
    }
}
