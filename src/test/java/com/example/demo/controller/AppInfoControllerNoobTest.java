package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AppInfoControllerNoobTest {

    @Autowired
    private AppInfoController appInfoController;

    @Test
    public void testGetAppInfo() {
        Map<String, String> expected = new HashMap<>();
        expected.put("appName", "demo");
        expected.put("port", "8080");

        assertEquals(expected, appInfoController.getAppInfo());
    }

    @Test
    public void testGetName() {
        assertEquals("demo", appInfoController.getName());
    }

    @Test
    public void testGetPort() {
        assertEquals("8080", appInfoController.getPort());
    }
}
