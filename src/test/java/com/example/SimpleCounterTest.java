package com.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SimpleCounterTest {

    @Test
    public void shouldBeIncreased() {
        SimpleCounter simpleCounter = new SimpleCounter();
        Assert.assertEquals(1, simpleCounter.get());
        Assert.assertEquals(2, simpleCounter.get());
    }

    /**
     * Method should check that 2 threads could correctly increment counter
     * (or it can fail)
     */
    @Test
    public void shouldBeThreadSafe() {
        SimpleCounter simpleCounter = new SimpleCounter();
        //Thread thread1 = new ThreadImpl("Thread1");
        //Thread thread2 = new ThreadImpl("Thread2");


        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                simpleCounter.get();
            }
        });

        //
        Thread thread2 = new ThreadImpl("Thread2");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished!");
    }

    /*
    First approach:
    class ThreadImpl extends Thread

     */
}
