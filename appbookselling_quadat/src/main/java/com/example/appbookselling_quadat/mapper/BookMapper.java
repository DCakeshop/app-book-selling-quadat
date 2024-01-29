package com.example.appbookselling_quadat.mapper;

import com.example.appbookselling_quadat.beans.response.BookResponse;
import com.example.appbookselling_quadat.entity.Book;

public class BookMapper {
    public static BookResponse convertToResponse(Book book){
        BookResponse bookResponse = new BookResponse();
        bookResponse.setTitle(book.getTitle());
        bookResponse.setAdminId(book.getAdminId());
        bookResponse.setAuthorId(book.getAuthorId());
        bookResponse.setCategoryId(book.getCategoryId());
        return bookResponse;
    }
}
