package com.example.slamstatsapi.Exceptions;

public class UserExistsException extends Exception{
    public UserExistsException(String message) {
        super(message);
    }
}
