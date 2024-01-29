package com.example.appbookselling_quadat.repository;

import com.example.appbookselling_quadat.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findAdminById(int id);
}
