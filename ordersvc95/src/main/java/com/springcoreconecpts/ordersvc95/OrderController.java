package com.springcoreconecpts.ordersvc95;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;


    @PostMapping("/create")
    public String createOrder(@RequestBody CreateOrderRequest createOrderRequest) {

        String orderId = UUID.randomUUID().toString();

//        this.restTemplate.getForEntity("http://localhost:8081/notif/get", String.class);
        this.restTemplate.getForEntity("http://notifsvc95/notif/get", String.class);

        return orderId;

    }
}
