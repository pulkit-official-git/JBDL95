package com.example.jbdl95bookmanagement.services;

import com.example.jbdl95bookmanagement.model.Book;
import com.example.jbdl95bookmanagement.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ObjectMapper objectMapper;

    public void create(Book book) throws SQLException {
//        if(book.getName()==null){
//            throw new Exception();
//        }
        this.bookRepository.createBook(book);
//        return 0;
    }

    public List<Book> getAll() throws SQLException {
        return this.bookRepository.getAll();
    }

    public Book getBook(Integer id) throws SQLException {
        return this.bookRepository.getBook(id);
    }

    public Book merge(Book incomingBook, Book existingBook){

        HashMap<String, Object> incoming = this.objectMapper.convertValue(incomingBook, HashMap.class);
        HashMap<String,Object> existing = this.objectMapper.convertValue(existingBook, HashMap.class);

        for(String key:incoming.keySet()){
            if(incoming.get(key)!=null){
                existing.put(key,incoming.get(key));
            }
        }

        Book mergedBook = this.objectMapper.convertValue(existing, Book.class);

        return mergedBook;

    }

    public Book update(Book incomingBook, Integer id) throws SQLException {

        Book existingBook = this.bookRepository.getBook(id);
        Book mergedBook = this.merge(incomingBook,existingBook);

        this.bookRepository.deleteById(id);
        this.bookRepository.createBookWithId(mergedBook);

        return this.getBook(id);

    }
}
