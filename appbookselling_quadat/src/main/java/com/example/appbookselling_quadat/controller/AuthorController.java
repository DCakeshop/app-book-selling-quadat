package com.example.appbookselling_quadat.controller;

import com.example.appbookselling_quadat.beans.response.AuthorResponse;
import com.example.appbookselling_quadat.entity.Author;
import com.example.appbookselling_quadat.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
@AllArgsConstructor
public class AuthorController {
    private AuthorService authorService;

    @GetMapping("/all")
    public List<AuthorResponse> getAllAuthor(){
        return authorService.getAuthorList();
    }

    @GetMapping("/{id}")
    public AuthorResponse getDetailAuthor(@PathVariable int id){
        return authorService.getDetailAuthor(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Author author){
        authorService.createAuthor(author);
    }

    @PutMapping("/edit")
    public void update(@RequestBody Author author){
        authorService.updateAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        authorService.delete(id);
    }
}
