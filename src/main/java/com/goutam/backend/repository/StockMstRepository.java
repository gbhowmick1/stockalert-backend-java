package com.goutam.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.goutam.backend.model.StockMst;

public interface StockMstRepository extends JpaRepository<StockMst,Integer> {
	
	
	@Query(value="select * from stock_mst where str_scrip_name ilike CONCAT(:name,'%') or str_company_name ilike CONCAT(:name,'%') order by str_company_name limit 10",nativeQuery=true)
	public List<StockMst> serachByStockName(String name); 
	
//	@Query(value="select sm.str_scrip_name, sm.str_company_name, sm.str_exchange "
	@Query(value="select sm from stock_mst sm JOIN sm.stock_user u where u.id=:userId")
	public List<StockMst> getWatchlistByUserId(Integer userId); 
	
}
