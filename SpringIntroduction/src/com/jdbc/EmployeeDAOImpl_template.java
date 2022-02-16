package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository(value = "template")
public class EmployeeDAOImpl_template implements EmployeeDAO {

	@Autowired
	JdbcTemplate template;

	@Override
	public int addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		int rows = 0;
		String Insert_Employee = "insert into hql values(?,?,?,?)";
		rows = template.update(Insert_Employee, employee.getId(), employee.getFirstName(), employee.getLastName(),
				employee.getSalary());
		return rows;
	}

	@Override
	public boolean updateEmplaoyee(int empId, String firstName) {
		// TODO Auto-generated method stub
		int rows = 0;
		boolean updated = false;
		rows = template.update("update hql set firstname=? where empid=?", firstName, empId);
		if (rows > 0)
			updated = true;
		return updated;
	}

	@Override
	public int deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		int rows = 0;
		boolean deleted = false;
		rows = template.update("delete from hql where empid=?", empId);
		return rows;
	}

	@Override
	public Employee findByEmpId(int empId) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		String Find_By_Id = "select* from hql where empid=?";
		try {
			employee = template.queryForObject(Find_By_Id, new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet set, int row_num) throws SQLException {
					// TODO Auto-generated method stub
					Employee emp = new Employee();
					emp.setId(set.getInt(1));
					emp.setFirstName(set.getString(2));
					emp.setLastName(set.getString(3));
					emp.setSalary(set.getInt(4));
					return emp;
				}
			}, empId);
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		return employee;
	}

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<Employee>();
		String Find_All = "select* from hql";
		try {
			employees = template.query(Find_All, (set, row_num) -> {
				Employee emp = new Employee();
				emp.setId(set.getInt(1));
				emp.setFirstName(set.getString(2));
				emp.setLastName(set.getString(3));
				emp.setSalary(set.getInt(4));
				return emp;
			});
		
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		return employees;
	}

}
