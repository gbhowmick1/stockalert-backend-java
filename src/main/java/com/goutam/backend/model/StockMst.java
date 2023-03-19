package com.goutam.backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="stock_mst")
public class StockMst {

    @Id
    @GeneratedValue
    private Integer num_scrip_id;
    private String str_scrip_name;
    private String str_company_name;
    private String str_exchange;
    
    
    @ManyToMany 
    @JoinTable(
    		name="watchlist",
    		joinColumns = { 
    				@JoinColumn(name= "num_scrip_id") 
    		} ,
			inverseJoinColumns = {
					@JoinColumn(name="num_user_id")
			}
    		) 
    private List<StockUser> stock_user;

    
    
    
    
	public Integer getNum_scrip_id() {
		return num_scrip_id;
	}
	public void setNum_scrip_id(Integer num_scrip_id) {
		this.num_scrip_id = num_scrip_id;
	}
	public String getStr_scrip_name() {
		return str_scrip_name;
	}
	public void setStr_scrip_name(String str_scrip_name) {
		this.str_scrip_name = str_scrip_name;
	}
	public String getStr_company_name() {
		return str_company_name;
	}
	public void setStr_company_name(String str_company_name) {
		this.str_company_name = str_company_name;
	}
	public String getStr_exchange() {
		return str_exchange;
	}
	public void setStr_exchange(String str_exchange) {
		this.str_exchange = str_exchange;
	}
	public StockMst(Integer num_scrip_id, String str_scrip_name, String str_company_name, String str_exchange,
			List<StockUser> stock_user) {
		super();
		this.num_scrip_id = num_scrip_id;
		this.str_scrip_name = str_scrip_name;
		this.str_company_name = str_company_name;
		this.str_exchange = str_exchange;
		this.stock_user = stock_user;
	}
	
	
	
	public StockMst() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StockMst [num_scrip_id=" + num_scrip_id + ", str_scrip_name=" + str_scrip_name + ", str_company_name="
				+ str_company_name + ", str_exchange=" + str_exchange + ", stock_user=" + stock_user + "]";
	}

	

    
    
    
    
}
