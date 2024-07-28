package com.example.springmvc.dao;

import com.example.springmvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PersonDAO {
    private static int peopleCount;
    private final List<Person> people;

    {
        people = new ArrayList<>(Arrays.asList(
                new Person(++peopleCount, "Tom"),
                new Person(++peopleCount, "Bob"),
                new Person(++peopleCount, "Mike"),
                new Person(++peopleCount, "Katy")
        ));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++peopleCount);
        people.add(person);
    }
}