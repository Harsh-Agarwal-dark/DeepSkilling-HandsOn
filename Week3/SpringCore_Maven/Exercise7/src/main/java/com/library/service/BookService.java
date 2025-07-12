package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
    private String serviceName;

    // Constructor for constructor injection
    public BookService(String serviceName) {
        this.serviceName = serviceName;
    }

    // Setter for setter injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void display() {
        System.out.println("Service: " + serviceName);
        bookRepository.getBook();
    }
}
