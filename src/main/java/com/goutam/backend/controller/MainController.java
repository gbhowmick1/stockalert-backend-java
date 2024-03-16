package com.goutam.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/")
	public String mainResponse(){
		return "StockAlert API Status: Active";
	}

	@GetMapping("/other")
	public String otherResponse(){
		return "From other api";
	}



	@GetMapping("/useradmin")
	public String useradminResponse(){
		return "From useradmin api";
	}


}
