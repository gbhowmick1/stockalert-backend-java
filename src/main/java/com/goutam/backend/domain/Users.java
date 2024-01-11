package com.goutam.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false, length=50) 
    private String username;
    
    @Column(nullable=false, length=50) 
    private String name;

    @Column(nullable=false, length=100, unique=true) 
    private String email;

    @Column(nullable=false, length=10)
    private  String mobile;
    
    private Integer age;
    private String nationality;

}
