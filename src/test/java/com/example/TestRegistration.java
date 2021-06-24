package com.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class TestRegistration {

    @Test
    public void test() {
        RegisterUser registerUser = new RegisterUser(new SimpleCounter());
        registerUser.register("user1");
        registerUser.register("user2");

        Map<String, Integer> users = registerUser.getUsers();

        Assert.assertEquals(Integer.valueOf(1), users.get("user1"));
        Assert.assertEquals(Integer.valueOf(2), users.get("user2"));
    }

}
