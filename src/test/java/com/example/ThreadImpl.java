package com.example;

public class ThreadImpl extends Thread {

    final String nameOfThread;

    public ThreadImpl(String nameOfThread) {
        this.nameOfThread = nameOfThread;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("Step: " + i + " Hello from thread: " + nameOfThread);
        }
    }
}
