package com.example.appbookselling_quadat.repository;

import com.example.appbookselling_quadat.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findAuthorById(int id);
    Author findAuthorByName(String name);
}
