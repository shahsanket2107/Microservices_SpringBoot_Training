package com.hibernate_query_lang;

public class FindAll {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAOImpl();
		dao.listAllEmployees().forEach(System.out::println);
		System.out.println("Finding values by column.......");
		dao.listAllEmployeesByCol().forEach((result)->{System.out.println(result[0]+"\t"+result[1]);});
		System.out.println("Finding values by column using salary filter.......");
		dao.listAllEmployeesByCol(5000).forEach((result)->{System.out.println(result[0]+"\t"+result[1]);});
		System.out.println("Updating values................");
		int check=dao.updateEmployee(99999,1);
		if(check==0)
			System.out.println("Not updates!!");
		else
			System.out.println("Updated successfully!!!");
		System.out.println("Named Query!!!!!!!!!");
		dao.query().forEach(System.out::println);
		System.out.println("Named Query!!!! Finding values by column using salary filter.......");
		dao.mult_qury_with_param().forEach((result)->{System.out.println(result[0]+"\t"+result[1]);});
	}
	
}
