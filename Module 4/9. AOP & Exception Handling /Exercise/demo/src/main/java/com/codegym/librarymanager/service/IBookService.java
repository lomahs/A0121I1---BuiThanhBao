package com.codegym.librarymanager.service;

import com.codegym.librarymanager.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IBookService {

    Page<Book> listBooks(Pageable pageable);

    Book getBookById(int id);

    void giveBack(Book book);

    void borrow(Book book) throws Exception;
}