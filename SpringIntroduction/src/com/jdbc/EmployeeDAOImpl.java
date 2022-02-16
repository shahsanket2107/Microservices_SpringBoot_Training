package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="emp_data")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	DataSource datasource;
	
	@Override
	public int addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		int rows=0;
		String Insert_Employee="insert into hql values(?,?,?,?)";
		try {
			Connection connection=datasource.getConnection();
			PreparedStatement ps = connection.prepareStatement(Insert_Employee);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getFirstName());
			ps.setString(3,employee.getLastName());
			ps.setInt(4, employee.getSalary());
			rows=ps.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public boolean updateEmplaoyee(int empId, String firstName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee findByEmpId(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
