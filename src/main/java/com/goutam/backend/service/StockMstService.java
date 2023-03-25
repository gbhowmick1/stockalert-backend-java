package com.goutam.backend.service;

import java.util.List;

import com.goutam.backend.model.StockMst;

public interface StockMstService {

	List<StockMst> searchByStockName(String name);

}
