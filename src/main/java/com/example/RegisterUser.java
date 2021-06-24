package com.example;

import java.util.HashMap;
import java.util.Map;

public class RegisterUser {

    Counter counter;
    Map<String, Integer> map = new HashMap<String, Integer>();

    RegisterUser(Counter counter) {
        this.counter = counter;
    }

    void register(String user) {
        map.put(user, counter.get());
    }

    Map<String, Integer> getUsers() {
        return map;
    }
}
