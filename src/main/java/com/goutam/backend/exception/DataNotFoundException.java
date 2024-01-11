package com.goutam.backend.exception;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(){
         super("Data Not Found");
    }
}
