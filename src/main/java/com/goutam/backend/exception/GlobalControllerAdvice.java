package com.goutam.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalControllerAdvice {

	
	
	// FROM SERVICE LAYER THROW RuntimeException WITH CUSTOM MESSAGE 
	// WHATEVER EXCEPTION COMES IN IT WILL HANDLE  
	
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> globalExceptionHandler(RuntimeException exception){

        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());
        return errorMap;
    }
    
    
    // THIS WILL CATCH ALL OTHER EXCEPTION IN YOUR APPLICATION
    
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> globalExceptionHandler(Exception exception){

        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());
        return errorMap;
    }
    
    
    
  //------------------------REDUNDANT START---------------------------------------

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(UserNotFoundException exception){

        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());

        return errorMap;

    }
//------------------------REDUNDANT END--------------------------------------- 

}



//IF U USE @ControllerAdvice then U have to use @ResponseBody

//IF U USE @RestControllerAdvice then U don't have to use @ResponseBody








