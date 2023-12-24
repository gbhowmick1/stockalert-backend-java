package com.goutam.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goutam.backend.model.Users;
import com.goutam.backend.repository.UserRepository;
import com.goutam.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUser(){
		return userRepository.findAll();
	}


	@Override
	public Users saveUser(Users newUser) {
		return userRepository.save(newUser);
	}


	@Override
	public Users getUserById(Long id) {

        Optional<Users> userOpt = userRepository.findById(id);
        if(userOpt.isPresent())
            return userOpt.get();
        else
            throw new RuntimeException("user not found...");
        
        
//      return userRepository.findById(id)
//      .orElseThrow(() -> new UserNotFoundException(id));   
	}


	@Override
	public Users updateUserById(Long id, Users newUser) {
		
		Optional<Users> userDetailOpt = userRepository.findById(id);
        if(userDetailOpt.isPresent()){
        	Users userDetail = userDetailOpt.get();
        	
            if(newUser.getUsername() != null || newUser.getUsername().isEmpty())
                userDetail.setUsername(newUser.getUsername());
            
            if(newUser.getName() != null || newUser.getName().isEmpty())
                userDetail.setName(newUser.getName());
            
            if(newUser.getEmail() != null || newUser.getEmail().isEmpty())
                userDetail.setEmail(newUser.getEmail());
            
            return userRepository.save(userDetail);
            
        }else{
            throw new RuntimeException("user not found.");
        }
	}


	@Override
	public String deleteUserById(Long id) {
		
        Optional<Users> userOpt = userRepository.findById(id);
        if(userOpt.isPresent()) {
        	userRepository.deleteById(id);
        	 return  "User with id "+id+" has been deleted success.";
        }
        else {
        	throw new RuntimeException("user not found...");
        }
    }
	
}
