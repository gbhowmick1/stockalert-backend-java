package com.goutam.backend.repository;

import com.goutam.backend.model.StockUser;	
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockUserRepository extends JpaRepository<StockUser,Long> {
}
