package com.example.borrow_book.service;

import com.example.borrow_book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);
    void save(Book book);
    Book findById(Integer id);
}
