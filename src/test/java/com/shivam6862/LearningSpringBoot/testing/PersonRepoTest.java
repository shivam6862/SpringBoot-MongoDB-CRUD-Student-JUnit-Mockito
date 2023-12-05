package com.shivam6862.LearningSpringBoot.testing;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.assertj.core.api.Assumptions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
// import org.junit.jupiter.params.provider.CsvFileSource;
// import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
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
        assertFalse(personRepoController.getAllPeopleRepo().isEmpty());
        assertEquals(4, personRepoController.getAllPeopleRepo().size());
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

    @Test
    @DisplayName("Test contract creation on developer branch")
    public void testContractCreation() {
        System.out.println("Test contract creation on developer branch");
        Assumptions.assumeThat("DEV".equals(System.getProperty("ENV")));
        assertFalse(personRepoController.getAllPeopleRepo().isEmpty());
    }

    @Nested
    class RepeatedTests {
        @Test
        @DisplayName("Should call the check method 5 times")
        @RepeatedTest(value = 5, name = "Repeating test {currentRepetition} of {totalRepetitions}")
        public void testcallPersonfivetimes() {
            assertFalse(personRepoController.getAllPeopleRepo().isEmpty());
            System.out.println(personRepoController.getAllPeopleRepo().size());
        }
    }

    @Nested
    class ParameterizedTests {
        @DisplayName("Name should match the required Format")
        @ParameterizedTest
        // @CsvSource(value = { "Shivam, true", "Shrey, true", "Shyam, true", "Shashank,
        // true", "Pushpendra, true",
        // "Shivam Mapwal, false", "Shrey Mapwal, false", "Shyam Mapwal, false",
        // "Shashank Mapwal, false",
        // "Pushpendra Mapwal, false" })
        // @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
        @ValueSource(strings = { "Shivam", "Shrey", "Shyam", "Shashank", "Pushpendra" })
        public void shouldTestNameFormatUsingValueSource(String name) {
            System.out.println(personRepoController.getAllPeopleRepo().size());
            System.out.println(name);

        }
    }

    @DisplayName("Method Source Case - Name should match the required Format")
    @ParameterizedTest
    @MethodSource("phoneNumberList")
    public void shouldTestPhoneNumberFormatUsingMethodSource(String name) {
        System.out.println(name);
    }

    private static List<String> phoneNumberList() {
        return Arrays.asList("Shivam", "Shrey", "Shyam", "Shashank", "Pushpendra");
    }

    @Test
    @DisplayName("Test Should Be Disabled")
    @Disabled
    public void shouldBeDisabled() {
        System.out.println("Should not run");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Should be executed at the end of the Test");
    }
}
