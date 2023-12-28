package com.goutam.backend.service;

import com.goutam.backend.dto.UserRequest;
import com.goutam.backend.model.Users;
import java.util.List;

public interface UserService {

	
	
	
	List<Users> getAllUser();

	Users saveUser(UserRequest newUser);

	Users getUserById(Long id);

	Users updateUserById(Long id, Users newUser);

	String deleteUserById(Long id);
	
}
