package com.pradeep.hibernatefull.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Table(name="user_details")
public class OneToManyAndManyToOneRelation {
	
	@Id
	@GeneratedValue
	private int userid;
	
	private String username;
	
	@OneToMany(mappedBy="users")
	private Collection<Vechile> vechiles= new ArrayList<Vechile>();

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

	public Collection<Vechile> getVechiles() {
		return vechiles;
	}

	public void setVechiles(Collection<Vechile> vechiles) {
		this.vechiles = vechiles;
	}
	
	
	
	

}
