package com.example.jbdl95jpahibernate.dtos;

import com.example.jbdl95jpahibernate.model.Book;
import com.example.jbdl95jpahibernate.model.Genre;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CreateBookRequest {


    private String name;

    private String author;

    private String authorEmail;

    private Genre genre;


    public Book toBook(){

        return Book.builder()
                .name(name)
                .authorEmail(authorEmail)
                .genre(genre)
                .author(author)
                .build();

    }


}
