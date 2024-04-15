package com.goutam.backend.dto;


//do validation from
//        https://www.youtube.com/watch?v=gPnd-hzM_6A&list=LL&index=1&ab_channel=JavaTechie

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor(staticName = "build")
public class UserRequest {

    @NotEmpty(message = "User Name shouldn't be Empty")
    private String username;

    @Email(message = "Invalid E-mail Address")
    private String email;

    @NotEmpty(message = "name can't be Empty")
    private String name;

    @Pattern(regexp="^\\d{10}$", message = "Invalid mobile number entered")
    private  String mobile;

    @Min(18)
    @Max(60)
    private Integer age;

    @NotEmpty(message = "nationality can't be Empty")
    private String nationality;

    @NotEmpty(message = "pass can't be Empty")
    private String password;

    @NotEmpty(message = "role can't be Empty")
    private String role;

}
