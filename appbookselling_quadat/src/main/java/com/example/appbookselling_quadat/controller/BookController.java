package com.example.appbookselling_quadat.controller;

import com.example.appbookselling_quadat.beans.response.BookResponse;
import com.example.appbookselling_quadat.entity.Book;
import com.example.appbookselling_quadat.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping("/all")
    public List<BookResponse> getAllBook(){
        return bookService.getBookList();
    }

    @GetMapping("/{id}")
    public BookResponse getDetailBook(@PathVariable int id){
        return bookService.getDetailBook(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Book book){
        bookService.createBook(book);
    }

    @PutMapping("/edit")
    public void update(@RequestBody Book book){
        bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        bookService.delete(id);
    }
}
