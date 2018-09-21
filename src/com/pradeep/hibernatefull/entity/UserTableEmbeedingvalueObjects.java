package com.pradeep.hibernatefull.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserTableEmbeedingvalueObjects")
public class UserTableEmbeedingvalueObjects {
	
	@Id
	private int userid;
	
	private String username;
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street", column=@Column(name="home_street_name")),
	@AttributeOverride(name="city", column=@Column(name="home_city_name")),
	@AttributeOverride(name="state", column=@Column(name="home_state_name")),
	@AttributeOverride(name="pincode", column=@Column(name="home_pincode_name"))})
	private Address homeaddress;
	
	
	public Address getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(Address homeaddress) {
		this.homeaddress = homeaddress;
	}

	public Address getOfficeaddress() {
		return officeaddress;
	}

	public void setOfficeaddress(Address officeaddress) {
		this.officeaddress = officeaddress;
	}

	@Embedded
	private Address officeaddress;
	
	

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
