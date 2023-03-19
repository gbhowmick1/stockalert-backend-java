package com.goutam.backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;

@Entity(name="stock_user")
public class StockUser {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stockuserid_generator")
    @SequenceGenerator(name="stockuserid_generator",initialValue=1,allocationSize=1,sequenceName="stockuser_sequence")
    private Integer id;
    private String name;
    private String email;
    private String password;

//    @ManyToMany 
//    @JoinTable(
//    		name="watchlist",
//    		joinColumns = { 
//    				@JoinColumn(name= "num_user_id") 
//    		} ,
//			inverseJoinColumns = {
//					@JoinColumn(name="num_scrip_id")
//			}
//    		) 
//    private List<StockMst> watchlist;




   

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StockUser(Integer id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public StockUser() {
		super();
	}

	@Override
	public String toString() {
		return "StockUser [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
    
    
}
