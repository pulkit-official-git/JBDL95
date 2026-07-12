package com.example.interfacebeanquali;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("us-bean")
//@Primary
public class UsCalculator implements Calculator{
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        return a-b;
    }
}
