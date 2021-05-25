package com.udacity.graphql.exception;

public class DogNotFoundException extends Exception {
    public DogNotFoundException(String message, Long invalidDogId) {
        super(message);
        this.getExtensions().put("invalidDogId", invalidDogId);
    }
}
