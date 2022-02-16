package com.jdbc;
import java.util.List;

public interface EmployeeDAO {
	public int addEmployee(Employee employee);

	boolean updateEmplaoyee(int empId, String firstName);

	int deleteEmployee(int empId);

	Employee findByEmpId(int empId);

	List<Employee> findAllEmployees();

}
