package com.example.demo;

import lombok.Data;

//the @Data annotation from Lombok generates getters, setters,
// toString, equals, and hashCode methods for the Person class.
@Data
public class Person {
    private Long id;
    private String name;
    private int age;
}