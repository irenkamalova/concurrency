package com.example;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCounter implements Counter {

    // static
    // incrementing volatile variable -> non-thread-safe
    int counter = 0;
    // AtomicInteger -> Compare And Set / Compare And Swap -> CAS
    final String counterName = "simpleCounter";

    /*
    Thread1 : counter = 100
    cachedCounter = 100
    cachedCounter = cachedCounter + 1

    ++counter -> 101
    -> put into counter = 101

    Thread2 : counter = 100
    cachedCounter = 100
    cachedCounter = cachedCounter + 1

    ++counter -> 101
    -> put into counter = 101

    -> 12798



     */

    /*
    * Thread1 _> get _> 100
    * _> 101
    * Thread2 _> 101 // Thread1 _> decrease _> 101
    * Thread2 _> 102 // Thread1 _> decrease _> 100
    * Thread1 _> decrease _> 100
    * Thread2 _> 102
    * Expected :0
    * Actual :52
    * */

    public synchronized int get() { // synchronized (this)
        //synchronized (counterName) {
            return ++counter;
        //}
    }

    public synchronized int decrease() { // synchronized (counterName)
        //synchronized (counterName) {
            return --counter;
        //}
    }

}
