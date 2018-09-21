package com.pradeep.hibernatefull.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class CascadeTypes {
	@Id
	@GeneratedValue
	private int userid;
	
	private String username;
	@OneToMany(cascade=CascadeType.PERSIST)
	private Collection<CascadeVechile> vechiles= new ArrayList<CascadeVechile>();
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Collection<CascadeVechile> getVechiles() {
		return vechiles;
	}
	public void setVechiles(Collection<CascadeVechile> vechiles) {
		this.vechiles = vechiles;
	}
	
	
	
	
	

}
