package com.baris.web.controller;

import com.baris.web.controller.Address;

public class Bank {
	private String type;
	private Integer distance;
	private Address address;
	
	public void setDistance(Integer inDistance) {
		this.distance = inDistance;
	}
	
	public void setType(String inType) {
		this.type = inType;
	}
	
	public String getType() {
		return this.type;
	}
	public Integer getDistance() {
		return this.distance;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
