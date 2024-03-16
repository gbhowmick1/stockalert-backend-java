package com.goutam.backend.controller;

import com.goutam.backend.Entity.Roles;
import com.goutam.backend.Entity.UserRole;
import com.goutam.backend.Event.AuditEventPublisher;
import com.goutam.backend.dto.UserRequest;
import com.goutam.backend.dto.UserResponse;
import com.goutam.backend.exception.DataNotFoundException;
import com.goutam.backend.Entity.Users;
import com.goutam.backend.repository.RolesRepository;
import com.goutam.backend.repository.UserRoleRepository;
import com.goutam.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.goutam.backend.constants.Role;
@RestController
//@CrossOrigin("http://localhost:3000")
public class UserController {

    private static final Logger logger
            = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private AuditEventPublisher auditEventPublisher;

    @PostMapping(path = "/user/register", produces = "application/json", consumes = "application/json")
    ResponseEntity<String> newUser(@RequestBody @Valid UserRequest userRequest) {
        try {
            String hashPwd = passwordEncoder.encode(userRequest.getPassword());
            userRequest.setPassword(hashPwd);
            Users savedUser = userService.saveUser(userRequest);
            List<String> roles = Arrays.asList("USER");
            if (!userRequest.getRole().isEmpty()) {
                roles = Arrays.asList(userRequest.getRole().split(","));
            }
            saveRoles(savedUser,roles);


            if (savedUser != null) {
//            This is optional for Observer design pattern
//            auditEventPublisher.publishEvent("User is Registered ="+savedUser.toString());

                return new ResponseEntity<String>("User Created Successfully", HttpStatus.CREATED);
            } else {
                logger.error("Runtime Exception -user creation Error");
                throw new RuntimeException("User  Creation Error");
            }
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/test")
    public String postTest() {
        return "Post Test";
    }


    @GetMapping("/user")
    public List<Users> getAllUsers() {


        List<Users> allUser = userService.getAllUser();

        if (allUser != null && allUser.size()>0) {
            return allUser;
        } else {
            throw new DataNotFoundException();
        }
    }

    @GetMapping("/user/pagination")
    public UserResponse getAllUsers(@RequestParam(value="pagenumber",required = false,defaultValue="1") Integer pageNumber,
                                   @RequestParam(value="pagesize",required = false,defaultValue = "3") Integer pageSize,
                                   @RequestParam(value="sortfield",required=false,defaultValue = "id") String sortfield,
                                   @RequestParam(value="sortdir",required=false,defaultValue = "asc") String sortDir
                                   ) {

        Page<Users> allUser = userService.getAllUser(pageNumber-1, pageSize, sortfield, sortDir);

//        IF U WANT TO RESTRICT PAGESIZE
//        Page<Users> allUser = userService.getAllUser(pageNumber>0 ?pageNumber-1: 0,
//                                                    pageSize<20 ? pageSize :20,
//                                                    sortfield,
//                                                    sortDir);

        UserResponse userResponse = UserResponse.builder()
                                        .content(allUser.getContent())
                                        .pageNo(allUser.getNumber())
                                        .pageSize(allUser.getSize())
                                        .totalPages(allUser.getTotalPages())
                                        .totalElements(allUser.getTotalElements())
                                        .last(allUser.isLast())
                                        .build();


        if (allUser.getContent().size()>0) {
            return userResponse;
        } else {
            throw new DataNotFoundException();
        }
    }

    @GetMapping("/user/id/{id}")
    ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));

    }

    @GetMapping("/user/name/{name}")
    public ResponseEntity<List<Users>> getUserByName(@PathVariable String name,
                                               @RequestParam(value="pagenum",required = false,defaultValue = "0") Integer pageNum,
                                               @RequestParam(value="pagesize", required = false,defaultValue = "20") Integer pageSize
                                               ) {
        return ResponseEntity.ok(userService.getUserByName(name, pageNum-1,pageSize ));
    }



    @PutMapping("/user/{id}")
    Users updateUser(@Valid @RequestBody UserRequest newUser, @PathVariable Long id) {
        return userService.updateUserById(id, newUser);

    }

    @PutMapping("/user/updateName")
    Boolean updateNamebyEmail(@RequestParam("name") String name, @RequestBody UserRequest userRequest ) {
        String email = userRequest.getEmail();
        if (email != null && !email.isEmpty() && name != null && !name.isEmpty()) {
            return userService.updateUserNameByEmail(name, userRequest.getName());
        } else {
            throw new RuntimeException("Email or Name can't be empty or null");
        }
    }



    @DeleteMapping("/user/{id}")
    ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }


    private void saveRoles(Users saveduser,List<String> roles) {
        try {
            List<Roles> allroles = rolesRepository.findAll();
            List<String> tosaveRole = roles.stream().map(e->e.toUpperCase()).collect(Collectors.toList());
            List<Roles> finalRoles = allroles.stream()
                    .filter( e -> tosaveRole.contains(e.getRoleName()))
                    .collect(Collectors.toList());
            List<UserRole> userRole = new ArrayList<>();

            userRole =   finalRoles.stream()
                    .map(e -> {
                        return UserRole.builder().userId(saveduser.getId().intValue()).roleId(e.getId()).build();
                    })
                    .collect(Collectors.toList());


            List<UserRole> savedRole = userRoleRepository.saveAll(userRole);
            System.out.println("savedRole.toString()");
            System.out.println(savedRole.toString());

        } catch (Exception e) {
                   logger.error(e.toString());
        }
    }


}
