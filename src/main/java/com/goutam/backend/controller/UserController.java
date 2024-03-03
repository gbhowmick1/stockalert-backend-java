package com.goutam.backend.controller;

import com.goutam.backend.Event.AuditEventPublisher;
import com.goutam.backend.dto.UserRequest;
import com.goutam.backend.exception.DataNotFoundException;
import com.goutam.backend.Entity.Users;
import com.goutam.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
//@CrossOrigin("http://localhost:3000")
public class UserController {

    private static final Logger logger
            = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private AuditEventPublisher auditEventPublisher;

    @PostMapping(path = "/user/save", produces = "application/json", consumes = "application/json")
    ResponseEntity<Users> newUser(@RequestBody @Valid UserRequest userRequest) {

        Users savedUser = userService.saveUser(userRequest);
        if (savedUser != null) {
//            This is optional for Observer design pattern
//            auditEventPublisher.publishEvent("User is Registered ="+savedUser.toString());

            return new ResponseEntity<Users>(savedUser, HttpStatus.CREATED);
        } else {
            logger.error("Runtime Exception -user creation Error");
            throw new RuntimeException("User  Creation Error");
        }

    }

    @GetMapping("/users")
    public List<Users> getAllUsers() {


        List<Users> allUser = userService.getAllUser();

        if (allUser != null) {
            return allUser;
        } else {
            throw new DataNotFoundException();
        }
    }

    @GetMapping("/user/{id}")
    ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));

    }

    @PutMapping("/user/{id}")
    Users updateUser(@Valid @RequestBody UserRequest newUser, @PathVariable Long id) {
        return userService.updateUserById(id, newUser);

    }

    @PutMapping("/user/updateName")
    Boolean updateNamebyEmail(@RequestParam("name") String name, @RequestBody UserRequest userRequest ) {
        String email = userRequest.getEmail();
        if (email != null && !email.isEmpty() && name != null && !name.isEmpty()) {
            return userService.updateUserNameByEmail(name, userRequest.getName());
        } else {
            throw new RuntimeException("Email or Name can't be empty or null");
        }
    }



    @DeleteMapping("/user/{id}")
    ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }


}
