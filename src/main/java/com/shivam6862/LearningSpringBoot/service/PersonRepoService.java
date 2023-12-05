package com.shivam6862.LearningSpringBoot.service;

import java.util.List;
import java.util.UUID;

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

    public Person getPersonRepoById(UUID id) {
        return personRepo.findById(id).orElse(null);
    }

    public int deletePersonRepo(UUID id) {
        personRepo.deleteById(id);
        return 1;
    }

    public int updatePersonRepo(UUID id, Person newPerson) {
        Person person = personRepo.findById(id).orElse(null);
        if (person != null) {
            person.setName(newPerson.getName());
            person.setEmail(newPerson.getEmail());
            person.setBranch(newPerson.getBranch());
            person.setSemester(newPerson.getSemester());
            person.setEnrollment(newPerson.getEnrollment());
            person.setCollege(newPerson.getCollege());
            personRepo.save(person);
            return 1;
        }
        return 0;
    }
}
