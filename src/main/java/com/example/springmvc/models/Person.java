package com.example.springmvc.models;

import javax.persistence.*;

import jakarta.validation.constraints.*;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name must not be empty")
    @Size(min = 2, max = 30, message = "Name must be between 2 & 30 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Age must be grater than 0")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be valid")
    @Column(name = "email")
    private String email;

    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Address must be in this format: Country, City," +
            " Postal code (6 digits).")
    @Column(name = "address")
    private String address;

    public Person() {

    }

    public Person(String name, int age, String email, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}