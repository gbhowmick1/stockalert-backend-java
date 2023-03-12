//package com.goutam.backend.controller;
//
//import com.goutam.backend.exception.UserNotFoundException;
//import com.goutam.backend.model.Users;
//import com.goutam.backend.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin("http://localhost:3000")
//public class StockMstController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("/user")
//    Users newUser(@RequestBody Users newUser) {
//        return userRepository.save(newUser);
//    }
//
//    @GetMapping("/users")
//    List<Users> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/user/{id}")
//    Users getUserById(@PathVariable Long id) {
//        return userRepository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException(id));
//    }
//
//    @PutMapping("/user/{id}")
//    Users updateUser(@RequestBody Users newUser, @PathVariable Long id) {
//        return userRepository.findById(id)
//                .map(user -> {
//                    user.setUsername(newUser.getUsername());
//                    user.setName(newUser.getName());
//                    user.setEmail(newUser.getEmail());
//                    return userRepository.save(user);
//                }).orElseThrow(() -> new UserNotFoundException(id));
//    }
//
//    @DeleteMapping("/user/{id}")
//    String deleteUser(@PathVariable Long id){
//        if(!userRepository.existsById(id)){
//            throw new UserNotFoundException(id);
//        }
//        userRepository.deleteById(id);
//        return  "User with id "+id+" has been deleted success.";
//    }
//
//
//
//}
