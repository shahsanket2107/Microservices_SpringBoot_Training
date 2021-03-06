package com.one_to_many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

@Entity
public class Person_One_to_Many {
	@Id
	private int personId;
	private String name;

	@OneToMany(cascade=CascadeType.ALL)
    List<Address_One_to_Many> addresses;


	public Person_One_to_Many() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Person_One_to_Many(int personId, String name, List<Address_One_to_Many> addresses) {
		super();
		this.personId = personId;
		this.name = name;
		this.addresses = addresses;
	}


	@Override
	public String toString() {
		return "Person_One_to_Many [personId=" + personId + ", name=" + name + ", addresses=" + addresses + "]";
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


	public List<Address_One_to_Many> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<Address_One_to_Many> addresses) {
		this.addresses = addresses;
	}

	



}
