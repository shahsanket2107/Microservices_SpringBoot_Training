package com.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("container ready with beans");

		 Product o = (Product) context.getBean("p1");
		 System.out.println(o);
		 Product o1 = (Product) context.getBean("p1");
		 System.out.println(o1);
		 Product o2 = (Product) context.getBean("p1");
		 System.out.println(o2);
		 Product o3 = (Product) context.getBean("p1");
		 System.out.println(o3);

		
	}

}
