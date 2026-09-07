package com.springcoreconecpts.eurekadiscoverserver95;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoverServer95Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaDiscoverServer95Application.class, args);
    }

}
