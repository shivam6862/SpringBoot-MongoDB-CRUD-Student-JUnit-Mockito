package com.shivam6862.LearningSpringBoot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.shivam6862.LearningSpringBoot.model.Person;

@Repository("fakedao")
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID ID, Person person) {
        DB.add(new Person(ID, person.getName()));
        return 1;
    }

    // 2.
    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }
}
