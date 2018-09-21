package com.pradeep.hibernatefull.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="allvechile")
public class AllVechile {

	@Id
	@GeneratedValue
	private int vechileid;
	
	private String vechilename;
	
	@ManyToMany(mappedBy="vechile")
	private Collection<MappedbyManyToMany> users=new ArrayList<MappedbyManyToMany>();

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

	public Collection<MappedbyManyToMany> getUsers() {
		return users;
	}

	public void setUsers(Collection<MappedbyManyToMany> users) {
		this.users = users;
	}
	
	
}
