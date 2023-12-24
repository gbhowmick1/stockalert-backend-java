package com.goutam.backend.controller;

import com.goutam.backend.exception.UserNotFoundException;
import com.goutam.backend.model.StockUser;
import com.goutam.backend.repository.UserRepository;
import com.goutam.backend.service.StockUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
//@CrossOrigin("http://localhost:3000")
@RequestMapping("/stock")
public class StockUserController {

    
    private final StockUserService stockUserService;

    public StockUserController(StockUserService stockUserService) {
        this.stockUserService = stockUserService;
    }

    @PostMapping("/user")
    StockUser newUser(@RequestBody StockUser newUser) {
    	return stockUserService.saveUser(newUser); 
  }
    	
    @GetMapping("/all-user")
    public List<StockUser> getAllUsers() {
        return stockUserService.getAllUser();
    } 
    
    @GetMapping("/user/{id}")
    StockUser getUserById(@PathVariable Integer id) {
        return stockUserService.getUserById(id);
    }

    @PutMapping("/user/{id}")
    StockUser updateUser(@RequestBody StockUser newUser, @PathVariable Integer id) {
        return stockUserService.updateUserById(id,newUser);
        
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Integer id){
        return stockUserService.deleteUserById(id);
    }



}
