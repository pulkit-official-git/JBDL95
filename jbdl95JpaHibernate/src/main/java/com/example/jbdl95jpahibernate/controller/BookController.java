package com.example.jbdl95jpahibernate.controller;

import com.example.jbdl95jpahibernate.dtos.CreateBookRequest;
import com.example.jbdl95jpahibernate.model.Book;
import com.example.jbdl95jpahibernate.model.Genre;
import com.example.jbdl95jpahibernate.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping("/create")
    public Integer create(@RequestBody CreateBookRequest createBookRequest){
        return this.bookService.create(createBookRequest.toBook());
    }

    @GetMapping("/getAll")
    public List<Book> getAll(){
        return this.bookService.getAll();
    }

    @GetMapping("/get/id/{id}")
    public Book getBook(@PathVariable("id") Integer id){
        return this.bookService.getById(id);
    }

    @GetMapping("/get/genre")
    public List<Book> getByGenre(@RequestParam Genre genre){
        return this.bookService.getByGenre(genre);
    }

    @GetMapping("/get/genre/name")
    public List<Book> getByGenreAndName(@RequestParam Genre genre,
                                        @RequestParam String name){
        return this.bookService.getByGenreAndName(genre,name);
    }

    @PatchMapping("/update")
    public void updateGenreById(@RequestParam Genre genre,
                                @RequestParam Integer id){
        this.bookService.updateGenreById(id,genre);
    }

}
