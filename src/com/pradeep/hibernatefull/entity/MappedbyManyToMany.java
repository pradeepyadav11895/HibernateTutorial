package com.pradeep.hibernatefull.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class MappedbyManyToMany {
	
	@Id
	@GeneratedValue
	private int userid;
	
	private String username;
	
	@ManyToMany
	private Collection<AllVechile> vechile=new ArrayList<AllVechile>();

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

	public Collection<AllVechile> getVechile() {
		return vechile;
	}

	public void setVechile(Collection<AllVechile> vechile) {
		this.vechile = vechile;
	}

	
	
	

}
