package com.goutam.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goutam.backend.Entity.StockMst;
import com.goutam.backend.Entity.Watchlist;
import com.goutam.backend.service.WatchlistService;

@RestController()
//@CrossOrigin("http://localhost:3000")
@RequestMapping("/watchlist")
public class WatchlistController {

   
    private final WatchlistService watchlistService;

    public WatchlistController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    @PostMapping("/add")
    Watchlist addStockToWatchlist(@RequestBody Watchlist newStock) {
    	return watchlistService.addStockToWatchlist(newStock); 
  }
    	
    @GetMapping("/getbyuid/{uid}")
    public List<StockMst> getWatchlistByUserId(@PathVariable Integer uid) {
        return watchlistService.getWatchlistByUserId(uid);
    } 
    
    @DeleteMapping("/deletebyscripanduid/{scripId}/{uid}")
    String deleteStockFromWatchlist(@PathVariable Integer scripId,@PathVariable Integer uid){
        return watchlistService.deleteStockFromWatchlist(scripId,uid);
    }



}
