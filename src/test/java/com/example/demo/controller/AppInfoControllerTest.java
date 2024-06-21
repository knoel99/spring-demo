package com.example.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AppInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext applicationContext;

    @BeforeEach
    public void printProjectBeans() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        System.out.println("List of project beans provided by Spring Boot:");
        Stream.of(beanNames)
                .filter(beanName -> applicationContext.getBean(beanName).getClass().getPackage().getName().startsWith("com.example.demo"))
                .forEach(System.out::println);
    }

    @Test
    public void testApplicationContext() {
        // Verify that the AppInfoController bean is loaded
        boolean isAppInfoControllerPresent = applicationContext.containsBean("appInfoController");
        System.out.println("Is AppInfoController present: " + isAppInfoControllerPresent);
        assert isAppInfoControllerPresent;
    }
    @Test
    public void testGetAppInfo() throws Exception {
        mockMvc.perform(get("/app/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.appName").value("demo"))
                .andExpect(jsonPath("$.port").value("8080"));
    }

    @Test
    public void testGetAppName() throws Exception {
        mockMvc.perform(get("/app/name"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("demo"));
    }

    @Test
    public void testGetAppPort() throws Exception {
        mockMvc.perform(get("/app/port"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("8080"));
    }
}
