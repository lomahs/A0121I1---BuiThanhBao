package com.codegym.librarymanager.service.impl;

import com.codegym.librarymanager.model.Book;
import com.codegym.librarymanager.repository.BookRepository;
import com.codegym.librarymanager.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<Book> listBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void giveBack(Book book) {
        book.giveBack();
        bookRepository.save(book);
    }

    @Override
    public void borrow(Book book) throws Exception {
        book.borrow();
        bookRepository.save(book);
    }
}