package com.udacity.graphql.exception;

public class BreedNotFoundException extends Exception {
    public BreedNotFoundException(String message, String breed) {
        super(message);
        this.getExtensions().put("invalidBreedId", breed);
    }
}
