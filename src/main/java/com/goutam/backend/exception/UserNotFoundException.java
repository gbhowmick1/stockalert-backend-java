package com.goutam.backend.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super("User Not Found");
    }
    public UserNotFoundException(Long id){
        super("Could not found the user with id "+ id);
    }
}

