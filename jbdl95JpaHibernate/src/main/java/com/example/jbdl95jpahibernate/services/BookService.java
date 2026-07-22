package com.example.jbdl95jpahibernate.services;

import com.example.jbdl95jpahibernate.model.Book;
import com.example.jbdl95jpahibernate.model.Genre;
import com.example.jbdl95jpahibernate.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    public Integer create(Book book) {
        return bookRepo.save(book).getId();
    }

    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    public Book getById(Integer id) {
        return bookRepo.findById(id).orElse(null);
    }

    public List<Book> getByGenre(Genre genre) {
        return this.bookRepo.findByGenre(genre);
    }

    public List<Book> getByGenreAndName(Genre genre, String name) {
        return this.bookRepo.findByNameAndGenre(name, genre);
    }

    public void updateGenreById(Integer id, Genre genre) {
        this.bookRepo.update(id,genre);
    }

    /*
    * to deal with optional we have 3 ways:
    * 1. or else  -> null
    * 2. or else get -> get from some other resource
    * 3. or else throw -> throwing some exception
    * */
}
