package com.goutam.backend.service;

import com.goutam.backend.Entity.StockUser;
import java.util.List;

public interface StockUserService {

	
	
	List<StockUser> getAllUser();

	StockUser saveUser(StockUser newUser);

	StockUser getUserById(Integer id);

	StockUser updateUserById(Integer id, StockUser newUser);

	String deleteUserById(Integer id);
	
}
