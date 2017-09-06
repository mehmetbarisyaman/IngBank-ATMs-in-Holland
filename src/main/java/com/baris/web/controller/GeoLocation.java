package com.baris.web.controller;

public class GeoLocation {
	private String lat;
	private String lng;
	
	public void setLat(String inLat) {
		this.lat = inLat;
	}
	
	public void setLng(String inLng) {
		this.lng = inLng;
	}
	
	public String getLat(){
		return this.lat;
	}
	
	public String getLng(){
		return this.lng;
	}
	
}
