package com.springcoreconecpts.notifsvc95;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Notifsvc95Application {

    public static void main(String[] args) {
        SpringApplication.run(Notifsvc95Application.class, args);
    }

}
