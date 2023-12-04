package com.shivam6862.LearningSpringBoot.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private final UUID id;
    private final String name;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Person of(UUID id, String name) {
        return new Person(id, name);
    }
    // 0.
}
