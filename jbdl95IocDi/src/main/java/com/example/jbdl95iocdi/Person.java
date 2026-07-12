package com.example.jbdl95iocdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Person {

    Logger logger = LoggerFactory.getLogger(Person.class);

    String name;
    Integer id;

    public Person() {
        logger.info("inside default - {} " ,this);
    }

    public Person(String name, Integer id) {
        this.name = name;
        this.id = id;
        logger.info("inside parameterised - {} " ,this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
