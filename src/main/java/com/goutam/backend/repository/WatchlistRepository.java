package com.goutam.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.goutam.backend.dto.WatchlistDto;
import com.goutam.backend.model.StockMst;
import com.goutam.backend.model.Watchlist;

public interface WatchlistRepository extends JpaRepository<Watchlist,Integer> {

	@Query(value="select sm from stock_mst sm JOIN sm.stock_user u where u.id=:userId order by timestamp desc")
	public List<StockMst> getWatchlistByUserId(Integer userId); 
	
	
	@Query(value="select w from watchlist w where w.num_scrip_id=:scripId")
	public List<Watchlist> getWatchlistByScripId(Integer scripId);
	
	
	@Query(value="select w from watchlist w where w.num_scrip_id=:scripId and num_user_id=:userId")
	public Optional<Watchlist> getStockByScripAndUserId(Integer scripId, Integer userId);
}
