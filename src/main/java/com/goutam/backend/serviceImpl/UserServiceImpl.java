package com.goutam.backend.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.goutam.backend.dto.UserRequest;
import com.goutam.backend.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.goutam.backend.Entity.Users;
import com.goutam.backend.repository.UserRepository;
import com.goutam.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUser(){
        return userRepository.findAll();
    }


    @Override
    public Users saveUser(UserRequest userRequest) {

        //builder pattern
        Users user = Users.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .age(userRequest.getAge())
                .mobile(userRequest.getMobile())
                .username(userRequest.getUsername())
                .nationality(userRequest.getNationality())
                .build();


//        Users user = Users.build(
//                0L,userRequest.getName(), userRequest.getName(), userRequest.getEmail(),
//                userRequest.getMobile(),userRequest.getAge(),userRequest.getNationality()
//        );

        return userRepository.save(user);
    }


    @Override
    public Users getUserById(Long id) {

        Optional<Users> userOpt = userRepository.findById(id);
        if(userOpt.isPresent())
            return userOpt.get();
        else
            throw new UserNotFoundException(id);
        
        
//      return userRepository.findById(id)
//      .orElseThrow(() -> new UserNotFoundException(id));   
    }


    @Override
    public Users updateUserById(Long id, UserRequest userRequest) {

        Users user =
                userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        Users update = Users
                .builder()
                .name(userRequest.getName())
                .nationality(userRequest.getNationality())
                .username(userRequest.getUsername())
                .age(userRequest.getAge())
                .mobile(userRequest.getMobile())
                .build();
        Users updatedUser = userRepository.save(update);
        if (updatedUser != null) {
            return updatedUser;
        } else {
            throw new RuntimeException("Updation Error");
        }

    }

    @Override
    public Boolean updateUserNameByEmail(String email, String name) {

            int status = userRepository.updateUserNameByEmail(email, name);
            return status == 1;

    }


    @Override
    public ResponseEntity<String> deleteUserById(Long id) {

        Optional<Users> userOpt = userRepository.findById(id);
        if(userOpt.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User with id "+id+" has been successfully deleted.");
        }
        else {
            throw new UserNotFoundException(id);
        }
    }

}
