package com.example.jbdl95iocdi.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/test")
public class TestController {

//    feild injection
    @Autowired
    private final TestService testService;

    @Autowired
            TestConfiguration testConfiguration;

    @Autowired
            ObjectMapper objectMapper;

    TestRepository testRepository;


//    @value is a feild injection
//    @Value("${test.int.value}")
    Integer quantity;

//    @Value("${test.string.value}")
    String name;

//    @Value("${test.float.value}")
    Float price;


//    constructor injection
    @Autowired
    public TestController(TestService testService,@Value("${test.int.value}") Integer quantity,
                          @Value("${test.string.value}")
                          String name,
                          @Value("${test.float.value}")
                              Float price) {
        this.testService=testService;
        this.testService.hello();
        this.quantity=quantity;
        this.name=name;
        this.price=price;

    }

//    @Autowired
//    public TestController(TestRepository testRepository) {
//        this.testRepository=testRepository;
////        this.testService.hello();
//    }

    @GetMapping("/items")
    public HashMap<String, Object> getDetails(){
        HashMap<String,Object> hm = new HashMap<>();

        hm.put("name",this.name);
        hm.put("quantity",this.quantity);
        hm.put("price",this.price);

        return hm;

    }

}


/*
* we can give all para,meters in single constructor
*
* or we can define @Autowired over suitable constructor
*
* we cannot use final in field injection
*
* never use static with dependency injection
*
* */
/*
* code will run and print thew value
* code will break
* code will run but print null
* none
* */

//ObjectMapper