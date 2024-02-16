package com.example.appbookselling_quadat.service.Impl;

import com.example.appbookselling_quadat.beans.response.CategoryResponse;
import com.example.appbookselling_quadat.entity.Category;
import com.example.appbookselling_quadat.exception.DuplicateException;
import com.example.appbookselling_quadat.exception.NotFoundException;
import com.example.appbookselling_quadat.mapper.CategoryMapper;
import com.example.appbookselling_quadat.repository.CategoryRepository;
import com.example.appbookselling_quadat.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    @Override
    public List<CategoryResponse> getCategoryList() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getDetailCategory(int id) throws NotFoundException {
        Category category = categoryRepository.findCategoriesById(id);
        if (Objects.isNull(category)){
            throw new NotFoundException("Not Found Objects in Database");
        }
        return CategoryMapper.convertToResponse(category);
    }

    @Override
    public void createCategory(Category obj) {
        Category category = categoryRepository.findCategoriesByName(obj.getName());
        if (!Objects.isNull(category)){
            throw new DuplicateException("Name exist in Database");
        }
        else {
            categoryRepository.save(obj);
        }
    }

    @Override
    public void updateCategory(Category obj) {
        Category category = categoryRepository.findCategoriesByName(obj.getName());
        if (!Objects.isNull(category)){
            throw new DuplicateException("Name exist in Database");
        }
        else {
            categoryRepository.save(obj);
        }
    }

    @Override
    public void delete(int id) {
        Category category = categoryRepository.findCategoriesById(id);
        if (Objects.isNull(category)){
            throw new NotFoundException("Not Found Objects in Database");
        }
        else {
            categoryRepository.delete(category);
        }
    }
}
