package com.example.appbookselling_quadat.controller;

import com.example.appbookselling_quadat.beans.response.CategoryResponse;
import com.example.appbookselling_quadat.entity.Category;
import com.example.appbookselling_quadat.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<CategoryResponse> getAllCategory(){
        return categoryService.getCategoryList();
    }

    @GetMapping("/{id}")
    public CategoryResponse getDetailCategory(@PathVariable int id){
        return categoryService.getDetailCategory(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Category category){
        categoryService.createCategory(category);
    }

    @PutMapping("/edit")
    public void update(@RequestBody Category category){
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        categoryService.delete(id);
    }
}
