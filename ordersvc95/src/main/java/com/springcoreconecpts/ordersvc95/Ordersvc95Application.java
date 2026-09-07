package com.springcoreconecpts.ordersvc95;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Ordersvc95Application {

    public static void main(String[] args) {
        SpringApplication.run(Ordersvc95Application.class, args);
    }

}
