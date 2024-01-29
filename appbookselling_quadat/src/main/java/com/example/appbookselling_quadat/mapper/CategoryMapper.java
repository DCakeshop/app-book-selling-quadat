package com.example.appbookselling_quadat.mapper;

import com.example.appbookselling_quadat.beans.response.CategoryResponse;
import com.example.appbookselling_quadat.entity.Category;

public class CategoryMapper {
    public static CategoryResponse convertToResponse(Category category){
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setName(category.getName());
        return categoryResponse;
    }
}
