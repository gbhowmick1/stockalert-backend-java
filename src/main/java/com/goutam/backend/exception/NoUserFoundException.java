package com.goutam.backend.exception;

public class NoUserFoundException extends RuntimeException{
    public NoUserFoundException(){
         super("No User Found");
    }
}
