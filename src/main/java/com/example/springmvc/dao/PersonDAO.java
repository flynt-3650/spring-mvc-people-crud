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

    @Transactional
    public Person show(int id) {
        return sessionFactory.getCurrentSession().get(Person.class, id);
    }

    @Transactional
    public void save(@NotNull Person person) {
        sessionFactory.getCurrentSession().persist(person);
    }

    @Transactional
    public void update(int id, @NotNull Person updatedPerson) {
        sessionFactory.getCurrentSession().createQuery(
                "UPDATE Person p SET p.name = :name, p.age = :age, p.email = :email, p.address = :address WHERE p.id = :id")
                .setParameter("name", updatedPerson.getName())
                .setParameter("age", updatedPerson.getAge())
                .setParameter("email", updatedPerson.getEmail())
                .setParameter("address", updatedPerson.getAddress())
                .setParameter("id", updatedPerson.getId())
                .executeUpdate();
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        session.remove(person);
    }
}