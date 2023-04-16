package com.goutam.backend.service;

import com.goutam.backend.dto.WatchlistDto;
import com.goutam.backend.model.StockMst;
import com.goutam.backend.model.Watchlist;
import java.util.List;

public interface WatchlistService {

	

	Watchlist addStockToWatchlist(Watchlist newStock);

	String deleteStockFromWatchlist(Integer scripId, Integer uid);

	List<StockMst> getWatchlistByUserId(Integer uid);
	
}
