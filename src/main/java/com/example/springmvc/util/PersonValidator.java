package com.example.springmvc.util;

import com.example.springmvc.dao.PersonDAO;
import com.example.springmvc.models.Person;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(@NotNull Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(@NotNull Object target, @NotNull Errors errors) {
        Person person = (Person) target;


//        if (personDAO.show((person).getEmail()).isPresent()) {
//            errors.rejectValue("email", "", "This email is already taken.");
//        }
    }
}
