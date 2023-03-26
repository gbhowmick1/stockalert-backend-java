package com.goutam.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/")
	public String mainResponse(){
		return "StockAlert API Status: Active";
	}



}
