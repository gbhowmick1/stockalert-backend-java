package com.goutam.backend.Service;

import com.goutam.backend.Entity.Users;
import com.goutam.backend.dto.UserRequest;
import com.goutam.backend.repository.UserRepository;
import com.goutam.backend.service.UserService;
import com.goutam.backend.serviceImpl.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userServiceImpl;


    @Test
    public void  UserService_SaveUser_ReturnsUsers() {

        UserRequest userRequest = UserRequest.builder()
                                        .name("Goutam")
                                        .email("abc@gmail.com")
                                        .build();


        when(userRepository.save(Mockito.any(Users.class)))
                .thenReturn(Mockito.mock(Users.class));

        Users savedUser = userServiceImpl.saveUser(userRequest);

        Assertions.assertThat(savedUser).isNotNull();

    }



}
