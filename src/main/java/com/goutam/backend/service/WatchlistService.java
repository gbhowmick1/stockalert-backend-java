package com.goutam.backend.service;

import com.goutam.backend.model.Watchlist;
import java.util.List;

public interface WatchlistService {

	

	Watchlist addStockToWatchlist(Watchlist newStock);

	String deleteStockFromWatchlist(Integer watchlistId);
	
}
