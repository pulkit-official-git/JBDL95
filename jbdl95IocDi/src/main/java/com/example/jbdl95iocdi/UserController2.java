package com.example.jbdl95iocdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController2 {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    Person person;

    UserController2(){
//        logger.info("inside user controller2 this - {} person - {}",this,this.person);
    }

    @GetMapping("/hello2")
    public String hello(){
//        Person person = new Person("fred",1);
        logger.info("person object - {}",this.person);
        person.id=2;
        person.name="skr";
        logger.info("person object - {}",this.person);
        return "hello2";
    }
}
