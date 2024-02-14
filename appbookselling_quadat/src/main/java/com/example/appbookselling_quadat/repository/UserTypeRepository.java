package com.example.appbookselling_quadat.repository;

import com.example.appbookselling_quadat.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
    UserType findUserTypeById(int id);
    UserType findUserTypeByTypeName(String typeName);
}
