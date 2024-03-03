package com.goutam.backend.repository;

import com.goutam.backend.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {



    @Modifying
    @Transactional
    @Query("UPDATE Users U SET U.name=:names where U.email=:emails")
    int updateUserNameByEmail(String emails,String names);
    
}
