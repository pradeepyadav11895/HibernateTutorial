package com.pradeep.hibernatefull.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="vechile")
public class Vechile {
	
	@Id
	@GeneratedValue
	private int vechileid;
	
	private String vechilename;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private OneToManyAndManyToOneRelation users;
	
	

	public OneToManyAndManyToOneRelation getUsers() {
		return users;
	}

	public void setUsers(OneToManyAndManyToOneRelation users) {
		this.users = users;
	}

	public int getVechileid() {
		return vechileid;
	}

	public void setVechileid(int vechileid) {
		this.vechileid = vechileid;
	}

	public String getVechilename() {
		return vechilename;
	}

	public void setVechilename(String vechilename) {
		this.vechilename = vechilename;
	}

	
	
}
