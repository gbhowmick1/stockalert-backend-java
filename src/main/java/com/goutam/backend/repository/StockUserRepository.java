package com.goutam.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goutam.backend.domain.StockUser;

public interface StockUserRepository extends JpaRepository<StockUser,Integer> {
	
	

}
