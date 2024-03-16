package com.goutam.backend.dto;


//do validation from
//        https://www.youtube.com/watch?v=gPnd-hzM_6A&list=LL&index=1&ab_channel=JavaTechie

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class UserRequest {

    @NotNull(message = "User Name shouldn't be null")
    private String username;

    @Email(message = "Invalid E-mail Address")
    private String email;

    @NotNull(message = "name can't be null")
    private String name;

    @Pattern(regexp="^\\d{10}$", message = "Invalid mobile number entered")
    private  String mobile;

    @Min(18)
    @Max(60)
    private Integer age;

    @NotNull(message = "nationality can't be null")
    private String nationality;

    @NotNull(message = "pass can't be null")
    private String password;

    @NotNull(message = "role can't be null")
    private String role;

}
