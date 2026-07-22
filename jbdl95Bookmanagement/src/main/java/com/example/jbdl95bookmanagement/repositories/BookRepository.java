package com.example.jbdl95bookmanagement.repositories;

import com.example.jbdl95bookmanagement.model.Book;
import com.example.jbdl95bookmanagement.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {


    DatabaseRepository databaseRepository;

//    @Autowired
    public BookRepository(DatabaseRepository databaseRepository) throws SQLException {
        this.databaseRepository=databaseRepository;
        createTable();
    }
//
//    private Connection getConnection() throws SQLException {
//
//        if(connection==null){
//            connection = DriverManager.getConnection(this.url,this.username,this.password);
//        }
//        return connection;
//    }

    public void createTable() throws SQLException {

        String query = "create table if not exists book(id int primary key auto_increment,name varchar(50),author varchar(50),authorEmail varchar(50)" +
                ",genre varchar(50), createdOn date, updatedOn date )";

        Statement statement = this.databaseRepository.getConnection().createStatement();
        statement.execute(query);

    }

    public void createBook(Book book) throws SQLException {

        String query = "insert into book(name,author,authorEmail,genre,createdOn,updatedOn)" +
                "values(?,?,?,?,?,?)";

        PreparedStatement preparedStatement = this.databaseRepository.getConnection().prepareStatement(query);
        preparedStatement.setString(1,book.getName());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setString(3,book.getAuthorEmail());
        preparedStatement.setString(4,book.getGenre().name());
        preparedStatement.setDate(5,new Date(book.getCreatedOn().getTime()));
        preparedStatement.setDate(6,new Date(book.getUpdatedOn().getTime()));
        preparedStatement.execute();
    }

    public void createBookWithId(Book book) throws SQLException {

        String query = "insert into book(id,name,author,authorEmail,genre,createdOn,updatedOn)" +
                "values(?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = this.databaseRepository.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,book.getId());
        preparedStatement.setString(2,book.getName());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setString(4,book.getAuthorEmail());
        preparedStatement.setString(5,book.getGenre().name());
        preparedStatement.setDate(6,new Date(book.getCreatedOn().getTime()));
        preparedStatement.setDate(7,new Date(book.getUpdatedOn().getTime()));
        preparedStatement.execute();
    }

    public List<Book> getAll() throws SQLException {
        String query = "select * from book";

        Statement statement = this.databaseRepository.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Book> books = new ArrayList<>();
        while (resultSet.next()){
            Book book = new Book();
            book.setId(resultSet.getInt(1));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString(3));
            book.setAuthorEmail(resultSet.getString(4));
            book.setGenre(Genre.valueOf(resultSet.getString("genre")));
            book.setCreatedOn(resultSet.getDate("createdOn"));
            book.setUpdatedOn(resultSet.getDate("updatedOn"));

            books.add(book);
        }
        return books;

    }

    public Book getBook(Integer id) throws SQLException {

        String query = "select * from book where id = ?";

        PreparedStatement preparedStatement = this.databaseRepository.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Book book = new Book();
        while (resultSet.next()){
            book.setId(resultSet.getInt(1));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString(3));
            book.setAuthorEmail(resultSet.getString(4));
            book.setGenre(Genre.valueOf(resultSet.getString("genre")));
            book.setCreatedOn(resultSet.getDate("createdOn"));
            book.setUpdatedOn(resultSet.getDate("updatedOn"));
        }
        return book;

    }

    public void deleteById(Integer id) throws SQLException {

        String query = "delete from book where id = ?";

        PreparedStatement preparedStatement = this.databaseRepository.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();

    }
}

//sql date is child
//        java date is parent


/*
* difference between create statement vs prepare statemnt
*
* 1. create is for static and prepare is for dymanic
* 2. in create we pass query in execute function and in prepare statemernt we pass query in prepare statmnt
* 3.
* */