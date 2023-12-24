package com.goutam.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goutam.backend.model.StockMst;
import com.goutam.backend.service.StockMstService;

@RestController
@RequestMapping("/stock")
public class StockMstController {


	private static final Logger logger = LoggerFactory.getLogger(StockMstController.class);

	private final StockMstService stockMstService;

	public StockMstController(StockMstService stockMstService) {
		this.stockMstService = stockMstService;
	}

	@GetMapping("/search")
	public List<StockMst> searchByStockName(@RequestParam String name){
		logger.info("/search called with name="+name);
		return  stockMstService.searchByStockName(name);
	}



}
