package com.one_to_one;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address_One_to_One {
	@Id
	private int id;
	private Long pinCode;
	private String city;
	
	
	public Address_One_to_One() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address_One_to_One(int id, Long pinCode, String city) {
		super();
		this.id = id;
		this.pinCode = pinCode;
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Address_One_to_One [id=" + id + ", pinCode=" + pinCode + ", city=" + city + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getPinCode() {
		return pinCode;
	}
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
