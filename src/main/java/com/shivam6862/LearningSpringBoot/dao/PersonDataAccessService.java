package com.shivam6862.LearningSpringBoot.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.shivam6862.LearningSpringBoot.model.Person;

@Repository("mongodb")
public class PersonDataAccessService implements PersonDao {
    @Override
    public int insertPerson(UUID ID, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return List.of(new Person(UUID.randomUUID(), "name", "email", "branch", "semester",
                "enrollment", "college"));
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person update_person) {
        return 0;
    }
}
