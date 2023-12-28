package com.goutam.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String name;
    private String email;
    private  String mobile;
    private Integer age;
    private String nationality;

}
