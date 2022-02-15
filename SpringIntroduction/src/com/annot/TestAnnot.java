package com.annot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.annot.Product;

public class TestAnnot {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			ApplicationContext context = new ClassPathXmlApplicationContext("annot.xml");

			Product p=(Product)context.getBean("pro");
			System.out.println(p);
			
			Customer c=(Customer)context.getBean("cust");
			System.out.println(c);
		}

}
