package com.example.jbdl95iocdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jbdl95IocDiApplication {


    public static void main(String[] args) {
        SpringApplication.run(Jbdl95IocDiApplication.class, args);
    }

}
/*
*
* Bean:-
* Object inside ioc container
*
*
* spring follows partial singleton( it does not stop you from crdeating the obj)
*  Creating shared instance of singleton bean 'person' (scope of a object inside ioc container)
* Creating shared instance of singleton bean 'userController'
* Creating shared instance of singleton bean 'jbdl95IocDiApplication'
* */