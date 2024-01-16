package com.goutam.backend.controller;

import com.goutam.backend.dto.UserRequest;
import com.goutam.backend.exception.DataNotFoundException;
import com.goutam.backend.Entity.Users;
import com.goutam.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@CrossOrigin("http://localhost:3000")
public class UserController {

    
    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/save")
    ResponseEntity<Users> newUser(@RequestBody  @Valid UserRequest userRequest) {

        Users savedUser = userService.saveUser(userRequest);
        if(savedUser!=null){
            return new ResponseEntity<Users>(savedUser, HttpStatus.CREATED);
        } else{

            throw new RuntimeException("User  Creation Error");
        }

  }
    	
    @GetMapping("/users")
    public List<Users> getAllUsers() {


        List<Users> allUser = userService.getAllUser();
        if(allUser !=null){
            return allUser;
        } else {
            throw new DataNotFoundException();
        }
    } 
    
    @GetMapping("/user/{id}")
    ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return  ResponseEntity.ok(userService.getUserById(id));

    }

    @PutMapping("/user/{id}")
    Users updateUser(@RequestBody Users newUser, @PathVariable Long id) {
        return userService.updateUserById(id,newUser);
        
    }

    @DeleteMapping("/user/{id}")
    ResponseEntity<String> deleteUser(@PathVariable Long id){
        return userService.deleteUserById(id);
    }



}
