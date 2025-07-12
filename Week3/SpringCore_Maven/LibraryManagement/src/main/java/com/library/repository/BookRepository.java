package com.library.repository;

import org.springframework.stereotype.Component;

@Component
public class BookRepository {
    public void saveBook(String title) {
        System.out.println("Saving book: " + title);
    }
}
