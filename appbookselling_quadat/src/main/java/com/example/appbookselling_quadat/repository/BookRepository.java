package com.example.appbookselling_quadat.repository;

import com.example.appbookselling_quadat.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findBookById(int id);
    Book findBookByTitle(String title);
}
