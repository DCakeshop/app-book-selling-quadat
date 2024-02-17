package com.example.appbookselling_quadat.service;

import com.example.appbookselling_quadat.beans.response.BookResponse;
import com.example.appbookselling_quadat.entity.Book;
import com.example.appbookselling_quadat.exception.NotFoundException;

import java.util.List;

public interface BookService {
    List<BookResponse> getBookList();
    BookResponse getDetailBook(int id) throws NotFoundException;
    void createBook(Book obj);
    void updateBook(Book obj);
    void delete(int id);
}
