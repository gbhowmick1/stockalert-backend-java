package com.goutam.backend.controller;

import com.goutam.backend.exception.UserNotFoundException;
import com.goutam.backend.model.Users;
import com.goutam.backend.repository.UserRepository;
import com.goutam.backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    Users newUser(@RequestBody Users newUser) {
    	return userService.saveUser(newUser); 
  }
    	
    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return userService.getAllUser();
    } 
    
    @GetMapping("/user/{id}")
    Users getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/user/{id}")
    Users updateUser(@RequestBody Users newUser, @PathVariable Long id) {
        return userService.updateUserById(id,newUser);
        
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        return userService.deleteUserById(id);
    }



}
