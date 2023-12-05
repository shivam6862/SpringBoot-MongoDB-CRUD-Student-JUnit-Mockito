package com.shivam6862.LearningSpringBoot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.shivam6862.LearningSpringBoot.model.Person;

@Repository("fakedao")
public class FakePersonDataAccessService implements PersonDao {
    // 2.
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID ID, Person person) {
        DB.add(new Person(ID, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getID().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty())
            return 0;
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person update_person) {
        return selectPersonById(id).map(person -> {
            int indexOfPersonToUpdate = DB.indexOf(person);
            if (indexOfPersonToUpdate >= 0) {
                DB.set(indexOfPersonToUpdate, new Person(id, update_person.getName()));
                return 1;
            } else {
                return 0;
            }
        }).orElse(0);
    }
}
