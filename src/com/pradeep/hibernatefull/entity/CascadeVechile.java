package com.pradeep.hibernatefull.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vechiles")
public class CascadeVechile {

	@Id
	@GeneratedValue
	private int vechileid;
	
	private String vechilname;

	public int getVechileid() {
		return vechileid;
	}

	public void setVechileid(int vechileid) {
		this.vechileid = vechileid;
	}

	public String getVechilname() {
		return vechilname;
	}

	public void setVechilname(String vechilname) {
		this.vechilname = vechilname;
	}
	
	
	
}
