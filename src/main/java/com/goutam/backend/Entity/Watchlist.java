package com.goutam.backend.Entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="watchlist")
public class Watchlist {

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="watchlistid_generator")
    @SequenceGenerator(name="watchlistid_generator",initialValue=1,allocationSize=1,sequenceName="watchlist_sequence")
	private Integer num_watchlist_id;
	
    private Integer num_user_id;
    
    private Integer num_scrip_id;
    
    private Timestamp timestamp;

    
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getNum_watchlist_id() {
		return num_watchlist_id;
	}

	public void setNum_watchlist_id(Integer num_watchlist_id) {
		this.num_watchlist_id = num_watchlist_id;
	}

	public Integer getNum_user_id() {
		return num_user_id;
	}

	public void setNum_user_id(Integer num_user_id) {
		this.num_user_id = num_user_id;
	}

	public Integer getNum_scrip_id() {
		return num_scrip_id;
	}

	public void setNum_scrip_id(Integer num_scrip_id) {
		this.num_scrip_id = num_scrip_id;
	}

	
    
    
    
    
    
    
    
}
