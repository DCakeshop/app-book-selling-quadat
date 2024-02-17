package com.example.appbookselling_quadat.service.Impl;

import com.example.appbookselling_quadat.beans.response.BookResponse;
import com.example.appbookselling_quadat.entity.Book;
import com.example.appbookselling_quadat.exception.DuplicateException;
import com.example.appbookselling_quadat.exception.NotFoundException;
import com.example.appbookselling_quadat.mapper.BookMapper;
import com.example.appbookselling_quadat.repository.BookRepository;
import com.example.appbookselling_quadat.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    @Override
    public List<BookResponse> getBookList() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookMapper::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponse getDetailBook(int id) throws NotFoundException {
        Book book = bookRepository.findBookById(id);
        if (Objects.isNull(book)){
            throw new NotFoundException("Not Found Objects in Database");
        }
        return BookMapper.convertToResponse(book);
    }

    @Override
    public void createBook(Book obj) {
        Book book = bookRepository.findBookByTitle(obj.getTitle());
        if (!Objects.isNull(book)){
            throw new DuplicateException("Title exist in Database");
        }
        else {
            bookRepository.save(obj);
        }
    }

    @Override
    public void updateBook(Book obj) {
        Book book = bookRepository.findBookByTitle(obj.getTitle());
        if (!Objects.isNull(book)){
            throw new DuplicateException("Title exist in Database");
        }
        else {
            bookRepository.save(obj);
        }
    }

    @Override
    public void delete(int id) {
        Book book = bookRepository.findBookById(id);
        if (Objects.isNull(book)){
            throw new NotFoundException("Not Found Objects in Database");
        }
        else {
            bookRepository.delete(book);
        }
    }
}
