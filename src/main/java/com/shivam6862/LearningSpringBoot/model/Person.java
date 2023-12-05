package com.shivam6862.LearningSpringBoot.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

@Document(collection = "Persons")
public class Person {
    // 0.
    @Id
    private final UUID id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String email;
    @NotBlank
    private final String branch;
    @NotBlank
    private final String semester;
    @NotBlank
    private final String enrollment;
    @NotBlank
    private final String college;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("email") String email,
            @JsonProperty("branch") String branch, @JsonProperty("semester") String semester,
            @JsonProperty("enrollment") String enrollment, @JsonProperty("college") String college) {
        if (id == null)
            this.id = UUID.randomUUID();
        else
            this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.semester = semester;
        this.enrollment = enrollment;
        this.college = college;
    }

    public UUID getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBranch() {
        return branch;
    }

    public String getSemester() {
        return semester;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public String getCollege() {
        return college;
    }

    public static Person of(UUID id, String name, String email, String branch, String semester, String enrollment,
            String college) {
        return new Person(id, name, email, branch, semester, enrollment, college);
    }
}
