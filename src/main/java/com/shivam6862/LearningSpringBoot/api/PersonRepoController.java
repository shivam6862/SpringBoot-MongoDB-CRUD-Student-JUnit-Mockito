package com.shivam6862.LearningSpringBoot.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivam6862.LearningSpringBoot.model.Person;
import com.shivam6862.LearningSpringBoot.service.PersonRepoService;

import jakarta.validation.Valid;

@RequestMapping("api/v1/personrepo")
@RestController
public class PersonRepoController {
    // 4.
    private final PersonRepoService personRepoService;

    @Autowired
    public PersonRepoController(PersonRepoService personRepoService) {
        this.personRepoService = personRepoService;
    }

    @PostMapping
    public void addPersonRepo(@Valid @NonNull @RequestBody Person person) {
        personRepoService.addPersonRepo(person);
    }

    @GetMapping
    public List<Person> getAllPeopleRepo() {
        return personRepoService.getAllPeopleRepo();
    }

    @GetMapping(path = { "{id}" })
    public Person getPersonRepoById(@PathVariable("id") UUID id) {
        return personRepoService.getPersonRepoById(id);
    }

    @DeleteMapping(path = { "{id}" })
    public void deletePersonRepo(@PathVariable("id") UUID id) {
        personRepoService.deletePersonRepo(id);
    }

    @PutMapping(path = { "{id}" })
    public void updatePersonRepo(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personToUpdate) {
        personRepoService.updatePersonRepo(id, personToUpdate);
    }
}
