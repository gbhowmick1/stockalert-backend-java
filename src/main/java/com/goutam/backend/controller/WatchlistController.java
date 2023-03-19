package com.goutam.backend.controller;

import com.goutam.backend.exception.UserNotFoundException;
import com.goutam.backend.model.StockUser;
import com.goutam.backend.model.Watchlist;
import com.goutam.backend.repository.UserRepository;
import com.goutam.backend.service.StockUserService;
import com.goutam.backend.service.WatchlistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin("http://localhost:3000")
@RequestMapping("/watchlist")
public class WatchlistController {

   
    @Autowired
    private WatchlistService watchlistService;

    @PostMapping("/add")
    Watchlist addStockToWatchlist(@RequestBody Watchlist newStock) {
    	return watchlistService.addStockToWatchlist(newStock); 
  }
    	
    @GetMapping("/getbyuid/{uid}")
    public List<Watchlist> getWatchlistByUserId(@PathVariable Integer uid) {
        return watchlistService.getWatchlistByUserId(uid);
    } 
    
    @DeleteMapping("/deletebywid/{wid}")
    String deleteStockFromWatchlist(@PathVariable Integer wid){
        return watchlistService.deleteStockFromWatchlist(wid);
    }



}
