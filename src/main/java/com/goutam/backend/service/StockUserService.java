package com.goutam.backend.service;

import com.goutam.backend.model.StockUser;
import java.util.List;

public interface StockUserService {

	
	
	
	List<StockUser> getAllUser();

	StockUser saveUser(StockUser newUser);

	StockUser getUserById(Long id);

	StockUser updateUserById(Long id, StockUser newUser);

	String deleteUserById(Long id);
	
}
