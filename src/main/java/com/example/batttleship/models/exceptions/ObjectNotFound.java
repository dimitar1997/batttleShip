package com.example.batttleship.models.exceptions;

public class ObjectNotFound extends RuntimeException{
    public ObjectNotFound() {
        super("Object with id  not found!");

    }
}
