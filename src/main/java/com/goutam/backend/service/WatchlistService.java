package com.goutam.backend.service;

import com.goutam.backend.domain.StockMst;
import com.goutam.backend.domain.Watchlist;
import java.util.List;

public interface WatchlistService {

	

	Watchlist addStockToWatchlist(Watchlist newStock);

	String deleteStockFromWatchlist(Integer scripId, Integer uid);

	List<StockMst> getWatchlistByUserId(Integer uid);
	
}
