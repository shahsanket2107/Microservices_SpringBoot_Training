package com.hibernate_query_lang;

public class Test_Add_Employee {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDAO ME = new EmployeeDAOImpl();
		Integer empID1 = ME.addEmployee(1, "Zara", "Ali", 2000);
		System.out.println("insterted:-" + empID1);
		Integer empID2 = ME.addEmployee(2, "Daisy", "Das", 5000);
		System.out.println("insterted:-" + empID2);
		Integer empID3 = ME.addEmployee(34, "John", "Paul", 5000);
		System.out.println("insterted:-" + empID3);
		Integer empID4 = ME.addEmployee(45, "Mohd", "Yasee", 3000);
		System.out.println("insterted:-" + empID4);
		Integer empID5 = ME.addEmployee(6, "John12", "Paul12", 5000);
		System.out.println("insterted:-" + empID5);

	}

}
