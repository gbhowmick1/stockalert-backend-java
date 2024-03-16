package com.goutam.backend.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.goutam.backend.Entity.UserRole;
import com.goutam.backend.dto.UserRequest;
import com.goutam.backend.exception.DataNotFoundException;
import com.goutam.backend.exception.UserNotFoundException;
import com.goutam.backend.repository.UserRoleRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.goutam.backend.Entity.Users;
import com.goutam.backend.repository.UserRepository;
import com.goutam.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    public List<Users> getAllUser(){
        return userRepository.findAll();
    }

    public Page<Users> getAllUser(Integer pageNumber, Integer pageSize, String sortField, String sortDir){
//        Pageable pageable = PageRequest.of(pageNumber, pageSize,  Sort.by(sortField) );
//        return userRepository.findAll(pageable);

        Sort sort;
        if (sortDir.equals("asc")) {
            sort = Sort.by(sortField).ascending();
        } else {
            sort = Sort.by(sortField).descending();
        }
        Pageable pageable = PageRequest.of(pageNumber, pageSize,  sort );
        Page<Users> page = userRepository.findAll(pageable);
        return page;
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
                .password(userRequest.getPassword())
                .build();


//        Users user = Users.build(
//                0L,userRequest.getName(), userRequest.getName(), userRequest.getEmail(),
//                userRequest.getMobile(),userRequest.getAge(),userRequest.getNationality()
//      );

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

    @Override
    public List<Users> getUserByName(String name, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Users> page =  userRepository.findByName(name,pageable);
        List<Users> users = page.getContent();
        if(users.size()>0)  return  users;
        throw new DataNotFoundException();

    }

    @Override
    public List<UserRole> saveUserRole(Integer userid, List<String> roleList) {
        List<UserRole> role = Arrays.asList();
//        List<UserRole> role = roleList.stream()
//                .map(e -> UserRole.builder().userId(userid).role(e).build())
//                .collect(Collectors.toList());

        return userRoleRepository.saveAll(role);
    }

}
