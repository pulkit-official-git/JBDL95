package com.example.jbdl95bookmanagement;

import com.example.jbdl95bookmanagement.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Jbdl95BookmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(Jbdl95BookmanagementApplication.class, args);

        Book book = new Book();
//        book.setAuthor("HC Verma");
        System.out.println(book.getId());

        Book book2 = new Book(1, "hc@gmail.com","Intro to Phy","HC verma",null,null,null);
        System.out.println(book2);


//        chaining
//        Book book3 = new Book()
//                .Id(1)
//                .Name("Intro")
//                .CreatedOn(new Date());
//
//        System.out.println(book3);
//        book3.UpdatedOn(new Date());
//
//        System.out.println(book3);
//
//        book3.AuthorEmail("fred@");
//
//        System.out.println(book3);

        Book.BookBuilder b4 = Book.builder()
                .id(5)
                .name("Music");
//                .build();

        System.out.println(b4);


    }

}
