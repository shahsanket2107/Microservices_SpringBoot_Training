package com.annot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMyConfig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		Product ppp = (Product)context.getBean("p1");
		System.out.println(ppp);
	}

}
