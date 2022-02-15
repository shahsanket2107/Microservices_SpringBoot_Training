package com.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Container Ready with beans!!!");
		
		System.out.println("*******************");
		Product product = (Product) context.getBean("p");
		System.out.println(product);
		
		System.out.println("*******************");
		Product product1 = (Product) context.getBean("product_const");
		System.out.println("initial value:-" + product1);
		product1.setName("JellO");
		System.out.println("after setting new value:-" + product1);

		System.out.println("*******************");
		Product product_new = (Product) context.getBean("product_const");
		System.out.println("new initial value:-" + product_new);

		System.out.println("*******************");
		Customer cust = (Customer) context.getBean("cust");
		System.out.println(cust.getP());
		System.out.println(cust);

		System.out.println("*******************");
		Customer cust2 = (Customer) context.getBean("cust2");
		System.out.println(cust2.getP());
		System.out.println(cust2);
	}

}
