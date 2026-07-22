package com.example.jbdl95bookmanagement.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Book {

    private Integer id;

//    private String externalId;

//    public void setExternalId(String externalId) {
//        this.externalId = externalId + id + "firstId";
//    }

//    public Book Id(Integer id) {
//        this.id = id;
//        return this;
//    }
//
//    public Book Name(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public Book Author(String author) {
//        this.author = author;
//        return this;
//    }
//
//    public Book AuthorEmail(String authorEmail) {
//        this.authorEmail = authorEmail;
//        return this;
//    }
//
//    public Book Genre(Genre genre) {
//        this.genre = genre;
//        return this;
//    }
//
//    public Book CreatedOn(Date createdOn) {
//        this.createdOn = createdOn;
//        return this;
//    }
//
//    public Book UpdatedOn(Date updatedOn) {
//        this.updatedOn = updatedOn;
//        return this;
//    }

    private String name;
    private String author;
    private String authorEmail;
    private Genre genre;
    private Date createdOn;
    private Date updatedOn;

}
