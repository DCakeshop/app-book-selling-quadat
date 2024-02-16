package com.example.appbookselling_quadat.service;

import com.example.appbookselling_quadat.beans.response.CategoryResponse;
import com.example.appbookselling_quadat.entity.Category;
import com.example.appbookselling_quadat.exception.NotFoundException;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getCategoryList();
    CategoryResponse getDetailCategory(int id) throws NotFoundException;
    void createCategory(Category obj);
    void updateCategory(Category obj);
    void delete(int id);
}
