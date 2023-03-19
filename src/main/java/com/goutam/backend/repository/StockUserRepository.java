package com.goutam.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.goutam.backend.model.StockMst;
import com.goutam.backend.model.StockUser;

public interface StockUserRepository extends JpaRepository<StockUser,Integer> {
	
	

}
