package com.example.interfacebeanquali;

public interface Calculator {

    public int add(int a, int b);

    public int sub(int a, int b);
}

/*
* never make interfaces as beans
*
* but we have some exceptions
* like @Repository
*
* */
