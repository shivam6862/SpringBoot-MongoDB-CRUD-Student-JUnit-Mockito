package com.shivam6862.LearningSpringBoot.exception;

public class DatabaseWriteException extends RuntimeException {
    public DatabaseWriteException(String message) {
        super(message);
    }
}
