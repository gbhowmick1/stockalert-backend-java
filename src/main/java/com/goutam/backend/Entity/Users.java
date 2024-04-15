package com.goutam.backend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Entity
@Builder
@Table(name="users",schema="public")
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="native")
    @GenericGenerator(strategy = "native", name="native")
    private Long id;

    @Column(name="user_name",nullable=false, length=50)
    private String username;

    @Column(name="email",nullable=false, length=100, unique=true)
    private String email;

    @Column(name="name",nullable=false, length=50)
    private String name;


    @Column(name="mobile",nullable=false, length=20)
    private  String mobile;
    
    private Integer age;

    private String nationality;

    // @JsonIgnore will prohibit sending password field in API response
    @JsonIgnore
    private String password;

}





