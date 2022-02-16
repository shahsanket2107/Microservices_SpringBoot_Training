package com.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_JDBC_Template {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
		EmployeeDAO dao = (EmployeeDAO) context.getBean("template");
		System.out.println("**********************************************************");
		System.out.println("Inserting values");
//		Employee employee = new Employee();
//		employee.setId(8);
//		employee.setFirstName("Robert");
//		employee.setLastName("Downey");
//		employee.setSalary(8);
//		if(dao.addEmployee(employee)>0)
//		{
//			System.out.println("Row inserted successfully !!");
//		}
//		else
//		{
//			System.out.println("Alas!! Row not inserted!!");
//		}
		System.out.println("**********************************************************");
		System.out.println("Update values");
//		if (dao.updateEmplaoyee(8, "Bruce Banner")) {
//			System.out.println("Updated Successfully!!!");
//		} 
//		else {
//			System.out.println("Updation failed!!!!");
//		}
		
		System.out.println("**********************************************************");
		System.out.println("Deleting values");
//		if(dao.deleteEmployee(8)>0)
//		{
//			System.out.println("Record Deleted successfully!!!");
//		}
//		else
//		{
//			System.out.println("Records deletion failed!!!");
//		}
//		
		System.out.println("**********************************************************");
		System.out.println("Filtering values by Id");
//		Employee e= dao.findByEmpId(8);
//		if(e.getId()>0)
//		{
//			System.out.println(e);
//		}
//		else
//		{
//			System.out.println("No such Employee exists!!");
//		}
		
		System.out.println("**********************************************************");
		System.out.println("Showing all Employees!!!!");
		dao.findAllEmployees().forEach((tp)->{System.out.println(tp);});
		
	}
}
