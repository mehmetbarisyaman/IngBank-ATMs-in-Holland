package com.baris.web.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

import com.baris.web.controller.Bank;

import java.util.ArrayList;



public class Service{	
	
	public static JSONArray retrieveJSONArray() throws IOException, JSONException {
		InputStream is = new URL("https://www.ing.nl/api/locator/atms/").openStream();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			StringBuilder sb = new StringBuilder();
			int counter = 0;
			while((counter=br.read())!=-1){
				sb.append((char)counter);
			};
			String brokenJsonText = sb.toString();
			String fixedJsonText = brokenJsonText.substring(brokenJsonText.indexOf("["));
			JSONArray textArray = new JSONArray(fixedJsonText);
			return textArray;
		}finally {
			is.close();
		}
	}
	
	
	public static ArrayList<Bank> retrieveBanks() throws IOException{
		JSONArray jsonArray = retrieveJSONArray();
		ArrayList<Bank>banks = new ArrayList<Bank>();
		for(int i = 0; i < 50; i++) {
			JSONObject add = jsonArray.getJSONObject(i);
			Integer distance = (Integer) add.get("distance");
			String type = (String)add.get("type");
			JSONObject address = (JSONObject)add.get("address");
			String city = (String) address.get("city");
			String houseNumber = (String) address.get("housenumber");
			String street = (String) address.get("street");
			String postalCode = (String) address.get("postalcode");
			JSONObject geo = (JSONObject) address.get("geoLocation");
			String lat = (String) geo.get("lat");
			String lng = (String) geo.get("lng");
			Address newAddress = new Address();
			GeoLocation newGeo = new GeoLocation();
			newAddress.setCity(city);
			newAddress.setHouseNumber(houseNumber);
			newAddress.setPostalcode(postalCode);
			newAddress.setStreet(street);
			newGeo.setLat(lat);
			newGeo.setLng(lng);
			newAddress.setGeolocation(newGeo);
			Bank newBank = new Bank();
			newBank.setAddress(newAddress);
			newBank.setDistance(distance);
			newBank.setType(type);
			banks.add(newBank);
		}
		return banks;
	}
	
	public ArrayList<Bank> showBankUsingCity(String cityName) throws IOException{
		int i=0;
		ArrayList<Bank>selected = retrieveBanks();
		ArrayList<Bank>remaining = new ArrayList<Bank>();
		while(i<selected.size()) {
			if(cityName.equals(selected.get(i).getAddress().getCity())) {
				remaining.add(selected.get(i));
			}
			i++;
		}
		return remaining;
	}
}

