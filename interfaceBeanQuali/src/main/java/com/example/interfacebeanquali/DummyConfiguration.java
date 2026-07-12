package com.example.interfacebeanquali;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DummyConfiguration {

    @Bean("uk-bean")
    public UkCalculator ukCalculator(){
        return new UkCalculator();
    }

    @Bean("us-bean")
    public UsCalculator usCalculator(){
        return new UsCalculator();
    }
}
