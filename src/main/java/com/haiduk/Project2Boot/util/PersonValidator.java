package com.haiduk.Project2Boot.util;


import com.haiduk.Project2Boot.models.Person;
import com.haiduk.Project2Boot.services.PeopleService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PeopleService peopleService;

    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if (peopleService.findOneByFullName(person.getFullName()).isPresent()) {
            errors.rejectValue("fullName", "", "This full name is already taken");
        }

    }
}
