package com.hibernate_query_lang;
import java.util.List;

public interface EmployeeDAO {
	Integer addEmployee(int id, String fname, String lname, int salary);

	List<Employee> listAllEmployees();

	List<Object[]> listAllEmployeesByCol();

	List<Object[]> listAllEmployeesByCol(int salary);

	int updateEmployee(int salary, int id);

	List<Employee> query();

	List<Object[]> mult_qury_with_param();

}
