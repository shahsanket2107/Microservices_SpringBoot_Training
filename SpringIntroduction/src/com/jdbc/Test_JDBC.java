package com.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_JDBC {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
		EmployeeDAO dao = (EmployeeDAO) context.getBean("emp_data");
		Employee employee = new Employee();
		employee.setId(7);
		employee.setFirstName("Robert");
		employee.setLastName("Downey");
		employee.setSalary(7);
		if(dao.addEmployee(employee)>0)
		{
			System.out.println("Row inserted!!");
		}
		else
		{
			System.out.println("Row not inserted!!");
		}
	}
}
