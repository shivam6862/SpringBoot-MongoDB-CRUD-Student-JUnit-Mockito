package com.shivam6862.LearningSpringBoot.testing;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shivam6862.LearningSpringBoot.api.PersonRepoController;
import com.shivam6862.LearningSpringBoot.model.Person;

@SpringBootTest
public class PersonRepoTest {
    @Autowired
    private PersonRepoController personRepoController;

    @BeforeAll
    public static void setupAll() {
        System.out.println("Should print before all tests");
    }

    @BeforeEach
    @DisplayName("Should print before each test")
    public void setup() {
        System.out.println("Instantiating Repo");
        System.out.println(personRepoController);
    }

    @Test
    @DisplayName("Should create person")
    public void testaddPersonRepo() {
        Person personToAdd = new Person(
                UUID.randomUUID(),
                "Shrey mapwal",
                "Shrey@gmail.com",
                "Mechanical Engineering",
                "6",
                "21117121",
                "IIT Roorkee");
        personRepoController.addPersonRepo(personToAdd);
    }

    @Test
    @DisplayName("Should get all people")
    public void testgetAllPeopleRepo() {
        List<Person> alldata = personRepoController.getAllPeopleRepo();
        System.out.println("All people Data");
        System.out.println(alldata);
    }

    @Test
    @DisplayName("Should get person by id")
    public void testgetPersonRepoById() {
        List<Person> alldata = personRepoController.getAllPeopleRepo();
        Person personDetails = personRepoController.getPersonRepoById(alldata.get(0).getID());
        System.out.println("Person Details with index 0");
        System.out.println(personDetails);
    }

    @Test
    @DisplayName("Should delete person")
    public void testdeletePersonRepo() {
        List<Person> alldata = personRepoController.getAllPeopleRepo();
        personRepoController.deletePersonRepo(alldata.get(2).getID());
    }

    @Test
    @DisplayName("Should update person")
    public void testupdatePersonRepo() {
        List<Person> alldata = personRepoController.getAllPeopleRepo();
        Person personToUpdate = new Person(
                alldata.get(2).getID(),
                "Shrey Mapwal",
                "Shrey_mapwal@gmail.com",
                "Mechanical Engineering",
                "6",
                "21117121",
                "IIT, Roorkee");
        personRepoController.updatePersonRepo(alldata.get(2).getID(), personToUpdate);
    }
}
