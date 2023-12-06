package com.shivam6862.LearningSpringBoot.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
// import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.doReturn;
// import static org.mockito.Mockito.doThrow;
// import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.verifyNoInteractions;
// import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import com.shivam6862.LearningSpringBoot.dao.PersonDao;
import com.shivam6862.LearningSpringBoot.dao.PersonDataAccessMockService;
import com.shivam6862.LearningSpringBoot.exception.DatabaseReadException;
// import com.shivam6862.LearningSpringBoot.exception.DatabaseWriteException;
import com.shivam6862.LearningSpringBoot.model.Person;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PersonRepoMockTest {

        @InjectMocks
        private PersonDataAccessMockService personDataAccessMockService;

        @Mock
        private PersonDao personDao;

        @Spy
        private PersonDao personDao2;

        @Captor
        private ArgumentCaptor<Person> personArgumentCaptor;

        @Test
        @DisplayName("Create Mocks Using Annotations")
        public void demoCreateMocksUsingAnnotations() {
                // In the context of testing frameworks, annotations are metadata that provide
                // additional information about how a test class or method should be treated.
                // Common testing frameworks like JUnit and TestNG use annotations extensively.
                // Examples of testing annotations include `@Test`, `@Before`, `@After`, and
                // `@BeforeClass` in JUnit. Annotations help in organizing and configuring
                // tests, and they indicate the intent of the methods to the testing framework.
                UUID randomUUID1 = UUID.randomUUID();
                UUID randomUUID2 = UUID.randomUUID();
                Person person1 = new Person(
                                randomUUID1,
                                "Shrey mapwal",
                                "Shrey@gmail.com",
                                "Mechanical Engineering",
                                "6",
                                "21117121",
                                "IIT Roorkee");
                Person person2 = new Person(
                                randomUUID2,
                                "Shyam jayakannan",
                                "Shyam@gmail.com",
                                "Mechanical Engineering",
                                "6",
                                "21117126",
                                "IIT Roorkee");

                List<Person> newPerson = new ArrayList<>();
                newPerson.add(person1);
                newPerson.add(person2);

                when(personDao.selectAllPeople()).thenReturn(newPerson);
                when(personDao.selectPersonById(randomUUID1)).thenReturn(Optional.of(person1));
                when(personDao.selectPersonById(randomUUID2)).thenReturn(Optional.of(person2));

                List<Person> personList = personDataAccessMockService.getselectAllPeople();
                assertEquals(2, personList.size());

                Optional<Person> getperson1 = personDataAccessMockService.getselectPersonById(randomUUID1);
                Optional<Person> getperson2 = personDataAccessMockService.getselectPersonById(randomUUID2);
                System.out.println(getperson1.get().getName());
                System.out.println(getperson2.get().getName());
                assertEquals("Shrey mapwal", getperson1.get().getName());
                assertEquals("Shyam jayakannan", getperson2.get().getName());
        }

        @Test
        @DisplayName("Create Mocks Using Stubbing")
        public void demoCreateMocksUsingStubbing() {
                // Stubbing refers to the process of defining specific behaviors for methods on
                // mock objects. It involves providing predefined return values or throwing
                // exceptions when certain methods are called.

                UUID randomUUID1 = UUID.randomUUID();
                UUID randomUUID2 = UUID.randomUUID();
                List<UUID> personIds = new ArrayList<>();
                personIds.add(randomUUID1);
                personIds.add(randomUUID2);
                Person person1 = new Person(
                                randomUUID1,
                                "Shrey mapwal",
                                "Shrey@gmail.com",
                                "Mechanical Engineering",
                                "6",
                                "21117121",
                                "IIT Roorkee");
                Person person2 = new Person(
                                randomUUID2,
                                "Shyam jayakannan",
                                "Shyam@gmail.com",
                                "Mechanical Engineering",
                                "6",
                                "21117126",
                                "IIT Roorkee");

                when(personDao.selectAllPeople()).thenReturn(List.of(person1, person2));
                when(personDao.selectPersonById(randomUUID1)).thenReturn(Optional.of(person1));
                when(personDao.selectPersonById(randomUUID2)).thenReturn(Optional.of(person2));

                // Use the stubbed methods to test the business logic
                List<Person> people = personDao.selectAllPeople();
                Optional<Person> person1Optional = personDao.selectPersonById(randomUUID1);
                Optional<Person> person2Optional = personDao.selectPersonById(randomUUID2);

                // Add assertions to verify the results
                assertEquals(List.of(person1, person2), people);
                assertEquals(Optional.of(person1), person1Optional);
                assertEquals(Optional.of(person2), person2Optional);

                // doNothing().when(personDao) when this is a void function

        }

        @Test
        @DisplayName("Create Mocks Using behavior Verfication")
        public void demoCreateMocksUsingbehaviorVerfication() {
                // Behavior verification is about checking whether certain methods on mock
                // objects have been called with specific arguments or a specific number of
                // times.
                UUID randomUUID1 = UUID.randomUUID();
                Person person1 = new Person(
                                randomUUID1,
                                "Shrey mapwal",
                                "Shrey@gmail.com",
                                "Mechanical Engineering",
                                "6",
                                "21117121",
                                "IIT Roorkee");
                personDao2.insertPerson(randomUUID1, person1);
                personDao2.insertPerson(randomUUID1, person1);

                // The verify() method in Mockito is used to check that certain behavior
                // happened. It checks that a method was called with certain arguments.
                // times(2) indicates that the method was called twice.
                verify(personDao2, times(2)).insertPerson(randomUUID1, person1);

                // never() indicates that the method was never called.
                // verify(personDao2, never()).insertPerson(randomUUID1, person1);

                // verifyNoInteractions verifies that no methods were called on the mock.
                // verifyNoInteractions(personDao2);

                // selectPersonById is called once
                personDao2.selectPersonById(randomUUID1);
                verify(personDao2).selectPersonById(randomUUID1);

                // The InOrder interface in Mockito is used to ensure that invocations on mock
                // objects happen in a specific order.

                InOrder inOrder = Mockito.inOrder(personDao2);
                inOrder.verify(personDao2, times(2)).insertPerson(randomUUID1, person1);
                inOrder.verify(personDao2).selectPersonById(randomUUID1);

                // verify(personDao2, atLeast(1)).insertPerson(person1);
                verify(personDao2, atMost(2)).insertPerson(person1);
                verify(personDao2, atMostOnce()).insertPerson(person1);
        }

        @Test
        @DisplayName("Create Mocks Using Exception Handling")
        public void demoCreateMocksUsingExceptionHandling() throws SQLException {
                // Mockito allows you to stub methods to throw exceptions, enabling you to test
                // how your code handles exceptional scenarios.
                when(personDao.selectAllPeopleError()).thenThrow(SQLException.class);
                // when(personDao.selectAllPeopleError()).thenThrow(new SQLException("Database
                // not available"));
                // given(personDao.selectAllPeopleError()).willThrow(SQLException.class);
                assertThrows(DatabaseReadException.class, () -> personDataAccessMockService.getselectAllPeopleError());

                // doThrow(SQLException.class).when(personDao).deletePersonById(UUID.randomUUID());
                // assertThrows(DatabaseWriteException.class, () ->
                // personDataAccessMockService.getselectAllPeopleError());

        }

        @Test
        @DisplayName("Create Mocks Using Argument Captor")
        public void demoCreateMocksUsingArgumentCaptor() {
                // An argument captor is used to capture and inspect the arguments passed to a
                // mocked method during verification. It helps in asserting the values passed to
                // the method.
                UUID randomUUID1 = UUID.randomUUID();
                Person person1 = new Person(
                                randomUUID1,
                                "Shrey mapwal",
                                "Shrey@gmail.com",
                                "Mechanical Engineering",
                                "6",
                                "21117121",
                                "IIT Roorkee");

                personDao.insertPerson(person1);
                verify(personDao).insertPerson(personArgumentCaptor.capture());
                Person capturedPerson = personArgumentCaptor.getValue();
                assertEquals(person1, capturedPerson);
        }

        @Test
        @DisplayName("Create Mocks Using MockitoSpy")
        public void demoCreateMocksUsingMockitoSpy() {
                // Spies in Mockito allow you to create a partial mock of a real object, meaning
                // you can spy on a real instance and selectively stub or verify methods as
                // needed.
                UUID randomUUID1 = UUID.randomUUID();
                Person person1 = new Person(
                                randomUUID1,
                                "Shrey mapwal",
                                "Shrey@gmail.com",
                                "Mechanical Engineering",
                                "6",
                                "21117121",
                                "IIT Roorkee");

                doReturn(Optional.of(person1)).when(personDao2).selectPersonById(randomUUID1);
                Optional<Person> personOptional = personDao2.selectPersonById(randomUUID1);
                assertEquals(Optional.of(person1), personOptional);
        }

        @Test
        @DisplayName("Create Mocks Using Behavior-Driven Development")
        public void demoCreateMocksUsingBehaviorDrivenDevelopment() {
                // BDD is an approach to software development that emphasizes collaboration
                // between developers, QA, and non-technical stakeholders. In the context of
                // Mockito, BDD-style syntax helps express tests in a more natural language.
                UUID randomUUID1 = UUID.randomUUID();
                Person person1 = new Person(
                                randomUUID1,
                                "Shrey mapwal",
                                "Shrey@gmail.com",
                                "Mechanical Engineering",
                                "6",
                                "21117121",
                                "IIT Roorkee");

                given(personDao.selectPersonById(randomUUID1)).willReturn(Optional.of(person1));
                then(personDao).shouldHaveNoInteractions();
                Optional<Person> personOptional = personDao.selectPersonById(randomUUID1);
                then(personDao).should(times(1)).selectPersonById(randomUUID1);
                assertEquals(Optional.of(person1), personOptional);
                then(personDao).shouldHaveNoMoreInteractions();

        }

        @Test
        @DisplayName("Create Mocks Using Argument Matchers")
        public void demoCreateMocksUsingArgumentMatchers() {
                // Mockito provides argument matchers to make it more flexible when verifying or
                // stubbing methods that take arguments. Matchers allow you to specify
                // conditions rather than exact values.
                UUID randomUUID1 = UUID.randomUUID();
                Person person1 = new Person(
                                randomUUID1,
                                "Shrey mapwal",
                                "Shrey@gmail.com",
                                "Mechanical Engineering",
                                "6",
                                "21117121",
                                "IIT Roorkee");

                when(personDao.selectPersonById(Mockito.any(UUID.class))).thenReturn(Optional.of(person1));
                Optional<Person> personOptional = personDao.selectPersonById(randomUUID1);
                assertEquals(Optional.of(person1), personOptional);
                // any(), anyString(), anyInt(), anyBoolean(), anyList(), anyMap(), anySet(),
                // ,anyCollection(), anyLong(), anyDouble(), anyFloat(), anyShort(), anyByte()
                // anyChar(), anyObject(), anyVararg(), anySetOf(),
        }

}
