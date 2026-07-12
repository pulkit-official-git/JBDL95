package com.example.interfacebeanquali;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("uk-bean")
//@Primary
public class UkCalculator implements Calculator{
    @Override
    public int add(int a, int b) {
        return a+b+1;
    }

    @Override
    public int sub(int a, int b) {
        return Math.abs(a-b);
    }
}
