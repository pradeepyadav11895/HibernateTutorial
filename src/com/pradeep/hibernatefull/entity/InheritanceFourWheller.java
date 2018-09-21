package com.pradeep.hibernatefull.entity;

import javax.persistence.Entity;

@Entity
public class InheritanceFourWheller extends InheritenceVechile {
	
	private String steeringwheel;

	public String getSteeringwheel() {
		return steeringwheel;
	}

	public void setSteeringwheel(String steeringwheel) {
		this.steeringwheel = steeringwheel;
	}
	
	

}
