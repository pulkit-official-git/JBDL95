package com.example.jbdl95bookmanagement.controllers;

import com.example.jbdl95bookmanagement.dtos.CreateBookRequest;
import com.example.jbdl95bookmanagement.dtos.UpdateBookRequest;
import com.example.jbdl95bookmanagement.model.Book;
import com.example.jbdl95bookmanagement.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/create")
    public void createBook(@Valid @RequestBody CreateBookRequest createBookRequest) throws SQLException {
         bookService.create(createBookRequest.toBook());
    }

    @GetMapping("/getAll")
    public List<Book> getAll() throws SQLException {
        return this.bookService.getAll();
    }

    @GetMapping("/get")
    public Book getBook(@RequestParam Integer id) throws SQLException {
        return this.bookService.getBook(id);
    }

    @PatchMapping("/update")
    public Book updateBook(@RequestBody UpdateBookRequest updateBookRequest,
                           @RequestParam Integer id) throws SQLException {

        return this.bookService.update(updateBookRequest.toBook(),id);

    }

}
