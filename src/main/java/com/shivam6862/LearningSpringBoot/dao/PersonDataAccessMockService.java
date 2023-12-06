package com.shivam6862.LearningSpringBoot.dao;

import com.shivam6862.LearningSpringBoot.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PersonDataAccessMockService {

    private PersonDao personDao;

    public PersonDataAccessMockService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> getselectAllPeople() {
        System.out.println(personDao.selectAllPeople());
        return personDao.selectAllPeople();
    }

    public Optional<Person> getselectPersonById(UUID id) {
        System.out.println(id);
        return personDao.selectPersonById(id);
    }
}
