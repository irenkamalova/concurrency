package com.example;

public class SimpleCounter implements Counter {

    // static
    int counter = 0;

    public int get() {
        return ++counter;
    }

}
