package com.example.jbdl95iocdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserController2 {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    Person person = new Person();

    UserController2(){
        logger.info("inside user controller this - {}",this);
    }
}
