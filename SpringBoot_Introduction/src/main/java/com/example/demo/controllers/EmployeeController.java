package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jdbc.EmployeeDAO;
import com.example.demo.pojo.Employee;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeDAO dao;
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		System.out.println("Consumer Sent :-"+employee);
		//employee.setFirstName(employee.getFirstName().toUpperCase());
		int rows=dao.addEmployee(employee);
		if(rows>0)
			return employee;
		else
			return new Employee();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
	{
//		Employee employee=new Employee();
//		employee.setId(id);
		Employee e= dao.findByEmpId(id);
		if(e.getId()>0)
		{
			return new ResponseEntity<Employee>(e,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>>getEmployees()
	{
//		Employee e= new Employee();
//		e.setId(44);
//		Employee e1=new Employee();
//		e1.setFirstName("Jimmy");
//		return Arrays.asList(new Employee(),e,e1);
		List<Employee> employees=dao.findAllEmployees();
		if(employees.size()>0)
		{
			return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
		}
		else
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
		int row=dao.deleteEmployee(id);
		if(row>0)
		{
			return new ResponseEntity<Employee>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/employees/{id}/{name}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @PathVariable String name) {
		boolean row=dao.updateEmplaoyee(id,name);
		if(row)
		{
			return new ResponseEntity<Employee>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}

}
