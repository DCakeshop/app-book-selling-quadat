package com.example.appbookselling_quadat.repository;

import com.example.appbookselling_quadat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(int id);
    User findUserByUsername(String username);
}
