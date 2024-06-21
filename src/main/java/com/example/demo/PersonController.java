package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private List<Person> persons = new ArrayList<>();

    @GetMapping
    public List<Person> getAllPersons() {
        return persons;
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        Optional<Person> person = persons.stream().filter(p -> p.getId().equals(id)).findFirst();
        return person.orElse(null);
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        persons.add(person);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable Long id, @RequestBody Person newPerson) {
        persons.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .ifPresent(person -> {
                    person.setName(newPerson.getName());
                    person.setAge(newPerson.getAge());
                });
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        persons.removeIf(p -> p.getId().equals(id));
    }
}