package com.example.jbdl95bookmanagement.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class DatabaseRepository {


    private Connection connection;

    //    @Value("${spring.db.url}")
    private String url;
    //    @Value("${spring.db.username}")
    private String username;
    //    @Value("${spring.db.password}")
    private String password;


    public DatabaseRepository(
            @Value("${spring.db.url}") String url,
            @Value("${spring.db.username}") String username,
            @Value("${spring.db.password}")  String password

    ) throws SQLException {

        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection(this.url,this.username,this.password);
        }
        return connection;
    }
}
