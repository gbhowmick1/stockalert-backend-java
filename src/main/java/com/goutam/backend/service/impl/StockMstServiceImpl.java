package com.goutam.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.goutam.backend.domain.StockMst;
import com.goutam.backend.repository.StockMstRepository;
import com.goutam.backend.service.StockMstService;

@Service
public class StockMstServiceImpl implements StockMstService {
	
	private final StockMstRepository stockMstRepository;

	public StockMstServiceImpl(StockMstRepository stockMstRepository) {
		this.stockMstRepository = stockMstRepository;
	}

	@Override
	public List<StockMst> searchByStockName(String name) {
		return stockMstRepository.serachByStockName(name);
	}
}
