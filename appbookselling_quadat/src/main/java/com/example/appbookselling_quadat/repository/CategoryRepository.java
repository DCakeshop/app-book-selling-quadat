package com.example.appbookselling_quadat.repository;

import com.example.appbookselling_quadat.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoriesById(int id);
    Category findCategoriesByName(String name);
}
