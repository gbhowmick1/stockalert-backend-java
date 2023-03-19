package com.goutam.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goutam.backend.model.StockUser;
import com.goutam.backend.model.Watchlist;
import com.goutam.backend.repository.StockUserRepository;
import com.goutam.backend.repository.WatchlistRepository;
import com.goutam.backend.service.StockUserService;
import com.goutam.backend.service.WatchlistService;

@Service
public class WatchlistServiceImpl implements WatchlistService {

	@Autowired
	private WatchlistRepository watchlistRepository;

	@Override
	public Watchlist addStockToWatchlist(Watchlist newStock) {
		return watchlistRepository.save(newStock);
	}


	@Override
	public String deleteStockFromWatchlist(Integer watchlistId) {
		Optional<Watchlist> watchlistOpt = watchlistRepository.findById(watchlistId);
        if(watchlistOpt.isPresent()) {
        	watchlistRepository.deleteById(watchlistId);
        	 return  "Stock with id "+watchlistId+" has been deleted success.";
        }
        else {
        	throw new RuntimeException("Stock not found...");
        }
	}
	
	
	
		
}
