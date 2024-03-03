package com.goutam.backend.service;

import com.goutam.backend.dto.UserRequest;
import com.goutam.backend.Entity.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

	
	
	
	List<Users> getAllUser();

	Users saveUser(UserRequest newUser);

	Users getUserById(Long id);

	Users updateUserById(Long id, UserRequest newUser);

	Boolean updateUserNameByEmail(String email, String name);

	ResponseEntity<String> deleteUserById(Long id);
	
}
