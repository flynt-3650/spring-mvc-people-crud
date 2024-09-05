package com.example.springmvc.util;

import com.example.springmvc.models.Person;
import com.example.springmvc.services.PeopleService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    @Autowired
    public PersonValidator(PeopleService peopleService) {
    }

    @SuppressWarnings("null")
    @Override
    public boolean supports(@NotNull Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @SuppressWarnings("null")
    @Override
    public void validate(@NotNull Object target, @NotNull Errors errors) {
        // Person person = (Person) target;


        // it does nothing, don't delete it or half of the app won't work
    }
}
