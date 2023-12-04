package com.shivam6862.LearningSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shivam6862.LearningSpringBoot.dao.PersonDao;
import com.shivam6862.LearningSpringBoot.model.Person;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakedao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    // 3.
    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }
}
