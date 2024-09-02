package com.example.springmvc.dao;

import com.example.springmvc.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    public Person show(int id) {
        return null;
    }

    public Person show(String email) {
        return null;
    }

    public void save(@NotNull Person person) {

    }

    public void update(int id, @NotNull Person updatedPerson) {

    }

    public void delete(int id) {

    }
}