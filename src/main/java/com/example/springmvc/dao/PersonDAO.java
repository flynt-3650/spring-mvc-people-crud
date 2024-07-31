package com.example.springmvc.dao;

import com.example.springmvc.models.Person;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", new BeanPropertyRowMapper<>(Person.class), id)
                .stream()
                .findAny()
                .orElse(null);
    }

    public void save(@NotNull Person person) {
        jdbcTemplate.update("INSERT INTO person(name, age, email) VALUES(?, ?, ?)",
                person.getName(), person.getAge(), person.getEmail());
    }

    public void update(int id, @NotNull Person updatedPerson) {
        jdbcTemplate.update("UPDATE person SET name=?, age=?, email=? WHERE id=?",
                updatedPerson.getName(), updatedPerson.getAge(), updatedPerson.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }

    // TESTS BELOW - DO NOT INVOKE

    public void testMultipleUpdate() {
        List<Person> people = create1000People();

        long before = System.currentTimeMillis();

        for (Person person : people) {
            jdbcTemplate.update("INSERT INTO person VALUES(?, ?, ?, ?)",
                    person.getId(), person.getName(), person.getAge(), person.getEmail());
        }

        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }

    public void testBatchUpdate() {
        List<Person> people = create1000People();

        long before = System.currentTimeMillis();

        jdbcTemplate.batchUpdate("INSERT INTO person VALUES(?, ?, ?, ?)", new BatchPreparedStatementSetter() {
            @SuppressWarnings("null")
            @Override
            public void setValues(@NotNull PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, people.get(i).getId());
                preparedStatement.setString(2, people.get(i).getName());
                preparedStatement.setInt(3, people.get(i).getAge());
                preparedStatement.setString(4, people.get(i).getEmail());
            }

            @Override
            public int getBatchSize() {
                return people.size();
            }
        });

        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }

    private @NotNull List<Person> create1000People() {
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            people.add(new Person(i, "Name" + i, 30, "test" + i + "mail.ru"));
        }

        return people;
    }
}