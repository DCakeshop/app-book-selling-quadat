package com.example.appbookselling_quadat.mapper;

import com.example.appbookselling_quadat.beans.response.AuthorResponse;
import com.example.appbookselling_quadat.entity.Author;

public class AuthorMapper {
    public static AuthorResponse convertToResponse(Author author){
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setName(author.getName());
        return authorResponse;
    }
}
