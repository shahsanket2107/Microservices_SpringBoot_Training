package com.example.demo.pojo;

public class MyPojo {
	
	private String compName;
	private int pincode;
	
	public MyPojo() {
		// TODO Auto-generated constructor stub
	}

	public MyPojo(String compName, int pincode) {
		super();
		this.compName = compName;
		this.pincode = pincode;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "MyPojo [compName=" + compName + ", pincode=" + pincode + "]";
	}

	
	
}
