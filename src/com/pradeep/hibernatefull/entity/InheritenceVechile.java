package com.pradeep.hibernatefull.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="vechiles")
@Inheritance(strategy=InheritanceType.JOINED)
public class InheritenceVechile {

	@Id
	@GeneratedValue
	private int vechileid;

	private String vechilename;

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
