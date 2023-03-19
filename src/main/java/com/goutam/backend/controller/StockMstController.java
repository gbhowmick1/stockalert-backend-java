package com.goutam.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goutam.backend.model.StockMst;
import com.goutam.backend.service.StockMstService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/stock")
public class StockMstController {

	@Autowired
	StockMstService stockMstService;
	
	
	@GetMapping("/search")
	public List<StockMst> searchByStockName(@RequestParam String name){
		return  stockMstService.searchByStockName(name);
	}


}
