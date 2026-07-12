package com.example.jbdl95iocdi.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope("singleton")
public class TestConfiguration {

//    ObjectMapper objectMapper;
//
//    public TestConfiguration() {
//        this.objectMapper = new ObjectMapper();
//    }

    @Bean //component over method
    @Scope("prototype")
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
