package com.pradeep.hibernatefull.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity()
@Table(name="saving_collection_user")
public class SavingCollection {
	
	@Id
	@GeneratedValue
	private int userid;
	
	private String username;
	
	@ElementCollection
	@JoinTable(name="USER_ADDRESS",
	joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="my-generator",strategy="increment")
	@CollectionId(columns = { @Column(name="address_id") }, generator = "my-generator", type = @Type(type="long"))
	private Collection<Address> listofAddress=new ArrayList<Address>();
	
	

	public Collection<Address> getListofAddress() {
		return listofAddress;
	}

	public void setListofAddress(Collection<Address> listofAddress) {
		this.listofAddress = listofAddress;
	}

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
