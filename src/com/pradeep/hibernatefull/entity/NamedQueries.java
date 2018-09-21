package com.pradeep.hibernatefull.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="NamedQueries.id",query="from NamedQueries where userid= :userid ")
@NamedNativeQuery(name="NamedQueries.name",query="select * from NamedQueries where username= :username ",resultClass=NamedQueries.class)
public class NamedQueries {
	
	@Id
	@GeneratedValue
	private int userid;
	
	
	private String username;


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

}
