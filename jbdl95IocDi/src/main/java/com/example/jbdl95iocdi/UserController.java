package com.example.jbdl95iocdi;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
* IOC -> Inversion of Control
* Some objects are created before starting the application
*
* Spring created some objects and it creates before starting the application
* You need to tell spring which objects it needs to create
*
* Spring will create the objects of classes on which we provide or they have
* @COMPONENT AS an annotation directly or indirectly
*
* whenever spring creates an object itself, it stores the object in
* IOC container and programmatically its called as Application Context
*
* if spring creates it , spring will manage it
*
*
*
* DI :- Dependency Injection
*
* A phenomenon in which a particular class which has a dependency on some other class can get the reference of that class
*
*using @Autowired we can get the reference of the object present in ioc container
*
*
* getting the reference == injecting a dependency
*
* if object is not present in ioc container, can di happen? No
*
*
* Beans
* Bean scopes
* Types of dependency injection
*
* creatiing sping objects without @Component
*
* creating object with parameteriesed constructors
*
* */



@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

//    this is field injection

    @Autowired
    Person person;

//    @Autowired
//    Person person = new Person();
//    never do this

    UserController(){
        logger.info("inside user controller this - {} and person - {}",this,this.person);
    }


    @GetMapping("/hello")
    public String hello(){
//        Person person = new Person("fred",1);
        logger.info("person object - {}",this.person);
        return "hello";
    }
}
