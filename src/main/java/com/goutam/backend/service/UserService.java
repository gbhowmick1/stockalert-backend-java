package com.goutam.backend.service;

import com.goutam.backend.Entity.UserRole;
import com.goutam.backend.dto.UserRequest;
import com.goutam.backend.Entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {



	List<Users> getAllUser();
	Page<Users> getAllUser(Integer pageNumber, Integer pageSize, String sortField, String sortDir);

	Users saveUser(UserRequest newUser);

	Users getUserById(Long id);

	Users updateUserById(Long id, UserRequest newUser);

	Boolean updateUserNameByEmail(String email, String name);

	ResponseEntity<String> deleteUserById(Long id);

	List<Users> getUserByName(String name, Integer pageNumber, Integer pageSize);

	List<UserRole> saveUserRole(Integer userid, List<String> roleList);

}
