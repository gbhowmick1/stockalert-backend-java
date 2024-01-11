package com.goutam.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.goutam.backend.domain.StockUser;
import com.goutam.backend.repository.StockUserRepository;
import com.goutam.backend.service.StockUserService;

@Service
public class StockUserServiceImpl implements StockUserService {

	private final StockUserRepository stockUserRepository;

	public StockUserServiceImpl(StockUserRepository stockUserRepository) {
		this.stockUserRepository = stockUserRepository;
	}

	public List<StockUser> getAllUser(){
		return stockUserRepository.findAll();
	}


	@Override
	public StockUser saveUser(StockUser newUser) {
		return stockUserRepository.save(newUser);
	}


	@Override
	public StockUser getUserById(Integer id) {

        Optional<StockUser> userOpt = stockUserRepository.findById(id);
        if(userOpt.isPresent())
            return userOpt.get();
        else
            throw new RuntimeException("user not found...");
        
        
//      return stockUserRepository.findById(id)
//      .orElseThrow(() -> new UserNotFoundException(id));   
	}


	@Override
	public StockUser updateUserById(Integer id, StockUser newUser) {
		
		Optional<StockUser> userDetailOpt = stockUserRepository.findById(id);
        if(userDetailOpt.isPresent()){
        	StockUser userDetail = userDetailOpt.get();
            
            if(newUser.getName() != null || newUser.getName().isEmpty())
                userDetail.setName(newUser.getName());
            
            if(newUser.getEmail() != null || newUser.getEmail().isEmpty())
                userDetail.setEmail(newUser.getEmail());
            
            return stockUserRepository.save(userDetail);
            
        }else{
            throw new RuntimeException("user not found.");
        }
	}


	@Override
	public String deleteUserById(Integer id) {
		
        Optional<StockUser> userOpt = stockUserRepository.findById(id);
        if(userOpt.isPresent()) {
        	stockUserRepository.deleteById(id);
        	 return  "User with id "+id+" has been deleted success.";
        }
        else {
        	throw new RuntimeException("user not found...");
        }
    }
	
}
