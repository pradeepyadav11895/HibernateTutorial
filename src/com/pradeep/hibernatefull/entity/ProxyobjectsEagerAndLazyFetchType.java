package com.pradeep.hibernatefull.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class ProxyobjectsEagerAndLazyFetchType {
	@Id
	@GeneratedValue
	private int userid;
	
	private String username;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="user_address",joinColumns=@JoinColumn(name="user_id"))
	private Collection<Address> listofAddress=new ArrayList<Address>();

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

	public Collection<Address> getListofAddress() {
		return listofAddress;
	}

	public void setListofAddress(Collection<Address> listofAddress) {
		this.listofAddress = listofAddress;
	}
	
	

}
