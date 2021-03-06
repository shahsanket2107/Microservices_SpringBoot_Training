package com.one_to_one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person_One_to_One {
	@Id
	private int personId;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	private Address_One_to_One address;

	public Person_One_to_One() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person_One_to_One(int personId, String name, Address_One_to_One address) {
		super();
		this.personId = personId;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person_One_to_One [personId=" + personId + ", name=" + name + ", address=" + address + "]";
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address_One_to_One getAddress() {
		return address;
	}

	public void setAddress(Address_One_to_One address) {
		this.address = address;
	}

}
