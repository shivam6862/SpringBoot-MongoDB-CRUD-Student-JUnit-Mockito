package com.shivam6862.LearningSpringBoot.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.shivam6862.LearningSpringBoot.model.Person;

public interface PersonDao {
    // 1.
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);

}
