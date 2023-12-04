package com.shivam6862.LearningSpringBoot.dao;

import java.util.List;
import java.util.UUID;

import com.shivam6862.LearningSpringBoot.model.Person;

public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    // 1.
    List<Person> selectAllPeople();
}
