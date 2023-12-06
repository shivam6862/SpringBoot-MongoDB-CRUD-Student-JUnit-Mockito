package com.shivam6862.LearningSpringBoot.model;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

@Document(collection = "Persons")
public class Person {
    // 0.
    @Id
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String branch;
    @NotBlank
    private String semester;
    @NotBlank
    private String enrollment;
    @NotBlank
    private String college;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("email") String email,
            @JsonProperty("branch") String branch, @JsonProperty("semester") String semester,
            @JsonProperty("enrollment") String enrollment, @JsonProperty("college") String college) {

        this.id = (id == null) ? UUID.randomUUID() : id;
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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public static Person of(UUID id, String name, String email, String branch, String semester, String enrollment,
            String college) {
        return new Person(id, name, email, branch, semester, enrollment, college);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        return id == person.id &&
                Objects.equals(email, person.email) &&
                Objects.equals(enrollment, person.enrollment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, enrollment);
    }
}
