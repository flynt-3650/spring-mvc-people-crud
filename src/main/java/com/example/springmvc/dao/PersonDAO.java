package com.example.springmvc.dao;

import com.example.springmvc.models.Person;
import org.jetbrains.annotations.NotNull;
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
                new Person(++peopleCount, "Tom", 24, "tom@mail.ru"),
                new Person(++peopleCount, "Bob", 52, "bob@mail.ru"),
                new Person(++peopleCount, "Mike", 18, "mike@yahoo.com"),
                new Person(++peopleCount, "Katy", 34, "katy@gmail.com")));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people
                .stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(@NotNull Person person) {
        person.setId(++peopleCount);
        people.add(person);
    }

    public void update(int id, @NotNull Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}