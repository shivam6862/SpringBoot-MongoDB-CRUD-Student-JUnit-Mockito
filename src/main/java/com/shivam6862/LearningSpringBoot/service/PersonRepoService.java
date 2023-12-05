package com.shivam6862.LearningSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam6862.LearningSpringBoot.dao.PersonRepo;
import com.shivam6862.LearningSpringBoot.model.Person;

@Service
public class PersonRepoService {
    // 2,3.
    private final PersonRepo personRepo;

    @Autowired
    public PersonRepoService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public int addPersonRepo(Person person) {
        Person savedPerson = personRepo.save(person);
        return (savedPerson != null) ? 1 : 0;
    }

    public List<Person> getAllPeopleRepo() {
        return personRepo.findAll();
    }
}
