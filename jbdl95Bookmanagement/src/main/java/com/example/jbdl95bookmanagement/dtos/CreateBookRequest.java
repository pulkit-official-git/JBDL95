package com.example.jbdl95bookmanagement.dtos;

import com.example.jbdl95bookmanagement.model.Book;
import com.example.jbdl95bookmanagement.model.Genre;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CreateBookRequest {

    @NotBlank
    private String name;
    private String author;
    @Email
    private String authorEmail;
    private Genre genre;

    public Book toBook(){
        return Book.builder()
                .name(name)
                .author(author)
                .authorEmail(authorEmail)
                .genre(genre)
                .createdOn(new Date())
                .updatedOn(new Date())
                .build();
    }
}
