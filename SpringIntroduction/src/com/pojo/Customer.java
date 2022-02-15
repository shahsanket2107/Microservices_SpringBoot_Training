package com.pojo;

public class Customer {
	private int customerId;
	private String customerName;
	private Product p;
	public Customer() {	
		super();
		System.out.println("Cust default constructor!");
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerId, String customerName, Product p) {
		super();
		System.out.println("Cust parameterised constructor!!");
		this.customerId = customerId;
		this.customerName = customerName;
		this.p = p;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", p=" + p + "]";
	}
	
	
}
