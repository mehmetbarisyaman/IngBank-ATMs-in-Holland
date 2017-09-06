package com.baris.web.controller;

import com.baris.web.controller.GeoLocation;

public class Address {
	private String street;
	private String housenumber;
	private String postalcode;
	private GeoLocation geoLoc;
	private String city;
	
	
	public void setStreet(String inStreet) {
		this.street = inStreet;
	}
	
	public void setHouseNumber(String inHousenumber) {
		this.housenumber = inHousenumber;
	}
	
	public void setPostalcode(String inPostalcode) {
		this.postalcode = inPostalcode;
	}
	
	public void setGeolocation(GeoLocation inGeolocation) {
		this.geoLoc = inGeolocation;
	}
	
	public void setCity(String inCity) {
		this.city = inCity;
	}
	
	public String getStreet() {
		return this.street;
	}
	public String getHousenumber() {
		return this.housenumber;
	}
	public String getPostalcode() {
		return this.postalcode;
	}
	public GeoLocation getGeolocation() {
		return this.geoLoc;
	}
	public String getCity() {
		return this.city;
	}
	
	
	
	
	
}
