package com.example.appbookselling_quadat.service.Impl;

import com.example.appbookselling_quadat.beans.response.AuthorResponse;
import com.example.appbookselling_quadat.entity.Author;
import com.example.appbookselling_quadat.exception.DuplicateException;
import com.example.appbookselling_quadat.exception.NotFoundException;
import com.example.appbookselling_quadat.mapper.AuthorMapper;
import com.example.appbookselling_quadat.repository.AuthorRepository;
import com.example.appbookselling_quadat.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    @Override
    public List<AuthorResponse> getAuthorList() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(AuthorMapper::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponse getDetailAuthor(int id) throws NotFoundException {
        Author author = authorRepository.findAuthorById(id);
        if (Objects.isNull(author)){
            throw new NotFoundException("Not Found Object in Database");
        }
        return AuthorMapper.convertToResponse(author);
    }

    @Override
    public void createAuthor(Author obj) {
        Author author = authorRepository.findAuthorByName(obj.getName());
        if(!Objects.isNull(author)){
            throw new DuplicateException("Name exist in Database");
        }
        else {
            authorRepository.save(obj);
        }
    }

    @Override
    public void updateAuthor(Author obj) {
        Author author = authorRepository.findAuthorByName(obj.getName());
        if(!Objects.isNull(author)){
            throw new DuplicateException("Name exist in Database");
        }
        else {
            authorRepository.save(obj);
        }
    }

    @Override
    public void delete(int id) {
        Author author = authorRepository.findAuthorById(id);
        if (Objects.isNull(author)){
            throw new NotFoundException("Not Found Object in Database");
        }
        else {
            authorRepository.delete(author);
        }
    }
}
