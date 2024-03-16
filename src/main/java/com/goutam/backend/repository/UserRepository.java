package com.goutam.backend.repository;

import com.goutam.backend.Entity.Roles;
import com.goutam.backend.Entity.StockMst;
import com.goutam.backend.Entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Page<Users> findByName(String name, Pageable pageable);

    List<Users> findByEmail(String email);

    @Query(value="select r.roleName from Roles r  INNER JOIN UserRole u ON u.roleId=r.id where u.userId=:userId")
    List<String> findAllRolesByUserId(Integer userId);


//    @Query(value="select sm from stock_mst sm JOIN sm.stock_user u where u.id=:userId order by timestamp desc")
//    public List<StockMst> getWatchlistByUserId(Integer userId);


    @Modifying
    @Transactional
    @Query("UPDATE Users U SET U.name=:names where U.email=:emails")
    int updateUserNameByEmail(String emails,String names);
    
}
