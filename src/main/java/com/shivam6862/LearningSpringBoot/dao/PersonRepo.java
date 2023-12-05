package com.shivam6862.LearningSpringBoot.dao;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shivam6862.LearningSpringBoot.model.Person;

public interface PersonRepo extends MongoRepository<Person, UUID> {
    // 1.
}
