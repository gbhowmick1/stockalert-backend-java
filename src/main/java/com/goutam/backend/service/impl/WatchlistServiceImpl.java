package com.goutam.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.goutam.backend.domain.StockMst;
import com.goutam.backend.domain.Watchlist;
import com.goutam.backend.repository.WatchlistRepository;
import com.goutam.backend.service.WatchlistService;

@Service
public class WatchlistServiceImpl implements WatchlistService {

	private final WatchlistRepository watchlistRepository;

	public WatchlistServiceImpl(WatchlistRepository watchlistRepository) {
		this.watchlistRepository = watchlistRepository;
	}

	@Override
	public Watchlist addStockToWatchlist(Watchlist newStock) {
		List<Watchlist> stock = watchlistRepository.getWatchlistByScripId(newStock.getNum_scrip_id());
		if(stock.size()>0)	return new Watchlist();
		return watchlistRepository.save(newStock);
	}


	@Override
	public String deleteStockFromWatchlist(Integer scripId, Integer userId) {
		Optional<Watchlist> watchlistOpt = watchlistRepository.getStockByScripAndUserId(scripId, userId);
		System.out.println("founddddddddddd"+watchlistOpt.get().getNum_watchlist_id());
		if(watchlistOpt.isPresent()) {
        	watchlistRepository.deleteById(watchlistOpt.get().getNum_watchlist_id());
        	 return  "Stock with id "+watchlistOpt.get().getNum_watchlist_id()+" has been deleted Successfully.";
        }
        else {
        	throw new RuntimeException("Stock not found...");
        }
	}


	@Override
	public List<StockMst> getWatchlistByUserId(Integer uid) {
		return watchlistRepository.getWatchlistByUserId(uid);
	}
	
	
	
		
}
