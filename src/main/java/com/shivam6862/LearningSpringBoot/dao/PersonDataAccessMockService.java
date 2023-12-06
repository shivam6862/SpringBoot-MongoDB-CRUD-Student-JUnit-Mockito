package com.shivam6862.LearningSpringBoot.dao;

import com.shivam6862.LearningSpringBoot.exception.DatabaseReadException;
import com.shivam6862.LearningSpringBoot.model.Person;

import java.sql.SQLException;
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

    public int getselectAllPeopleError() {
        try {
            personDao.selectAllPeopleError();
        } catch (SQLException e) {
            throw new DatabaseReadException("Unable to read from database due to - " + e.getMessage());
        }
        return 1;
    }
}
