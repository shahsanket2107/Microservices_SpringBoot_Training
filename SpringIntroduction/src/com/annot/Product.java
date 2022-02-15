package com.annot;

import org.springframework.stereotype.Component;

@Component(value="pro")
public class Product { //product
	private int productId;
	private String name;
	public Product() 
	{
		System.out.println("Default Constructor!!");
		productId=1;
		name="Jimmy";
	}
	
	public Product(int productId, String name) {	
		super();
		System.out.println("Parameterised Constructor!!");
		this.productId = productId;
		this.name = name;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + "]";
	}

}
