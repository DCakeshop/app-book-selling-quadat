package com.example.appbookselling_quadat.service;

import com.example.appbookselling_quadat.beans.response.AuthorResponse;
import com.example.appbookselling_quadat.entity.Author;
import com.example.appbookselling_quadat.exception.NotFoundException;

import java.util.List;

public interface AuthorService {
    List<AuthorResponse> getAuthorList();
    AuthorResponse getDetailAuthor(int id) throws NotFoundException;
    void createAuthor(Author obj);
    void updateAuthor(Author obj);
    void delete(int id);
}
