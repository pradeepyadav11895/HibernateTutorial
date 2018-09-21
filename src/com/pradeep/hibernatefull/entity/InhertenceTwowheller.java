package com.pradeep.hibernatefull.entity;

import javax.persistence.Entity;

@Entity
public class InhertenceTwowheller extends InheritenceVechile {

	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	
	
	

}
