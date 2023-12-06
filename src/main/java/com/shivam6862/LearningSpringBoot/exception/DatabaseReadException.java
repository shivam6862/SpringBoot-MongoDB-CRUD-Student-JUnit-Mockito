package com.shivam6862.LearningSpringBoot.exception;

public class DatabaseReadException extends RuntimeException {
    public DatabaseReadException(String message) {
        super(message);
    }
}
