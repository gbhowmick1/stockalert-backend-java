package com.goutam.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goutam.backend.model.StockMst;
import com.goutam.backend.repository.StockMstRepository;
import com.goutam.backend.service.StockMstService;

@Service
public class StockMstServiceImpl implements StockMstService {
	
	@Autowired
	StockMstRepository stockMstRepository;

	
	@Override
	public List<StockMst> searchByStockName(String name) {
		return stockMstRepository.serachByStockName(name);
	}

}
