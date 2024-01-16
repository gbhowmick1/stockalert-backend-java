package com.goutam.backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Entity
@Table(name="users",schema="goutam")
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="native")
    @GenericGenerator(strategy = "native", name="native")
    private Long id;

    @Column(name="user_name",nullable=false, length=50)
    private String username;
    
    @Column(name="name",nullable=false, length=50)
    private String name;

    @Column(name="email",nullable=false, length=100, unique=true)
    private String email;

    @Column(name="mobile",nullable=false, length=10)
    private  String mobile;
    
    private Integer age;
    private String nationality;

}





