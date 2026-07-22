package com.example.jbdl95jpahibernate.repo;

import com.example.jbdl95jpahibernate.model.Book;
import com.example.jbdl95jpahibernate.model.Genre;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
    List<Book> findByGenre(Genre genre);

    List<Book> findByNameAndGenre(String name, Genre genre);

    @Transactional
    @Modifying
    @Query("update Book b set b.genre = ?2 where b.id=?1")
    void update(Integer id, Genre genre);

//    @Query(value = "select * from book where genre = :genre",nativeQuery = true)
//    List<Book> findByGenre(Genre genre);
//
//    @Query(value = "select * from book where genre = ?1",nativeQuery = true)
//    List<Book> findByGenre2(Genre genre);
//
//    @Query("select b from Book b where b.genre = :genre")
//    List<Book> findByGenre3(Genre genre);
//
//    @Query("select b from Book b where b.genre = ?1")
//    List<Book> findByGenre4(Genre genre);

    /*
    *
    * to write user defined queries we have 2 ways:-
    * 1. JPQL -> Java Persistent Query Language
    * 2. Native -> sql query
    *
    * Native is faster bcoz conversion is not required
    *
    * In Jpql we have abstraction but in native we have to know about ytable name and all attributes
    *
    * In jpql we have compile time checks but in native we dont have complie time checks
    * 
    * In jpql we have visibility but in native there is no visibility(error detection happens at run time)
    *
    * */
    
    
    /*
    * 
    * for dql -> data query language (select queries) we dont have to write queires manually we can jst use findBy
    * */
}
