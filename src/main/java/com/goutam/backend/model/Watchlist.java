package com.goutam.backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name="watchlist")
public class Watchlist {

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="watchlistid_generator")
    @SequenceGenerator(name="watchlistid_generator",initialValue=1,allocationSize=1,sequenceName="watchlist_sequence")
	private Integer num_watchlist_id;
	
    private Integer num_user_id;
    
    private Integer num_scrip_id;
    
    
    
}
