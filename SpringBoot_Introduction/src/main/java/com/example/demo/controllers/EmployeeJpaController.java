package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.jdbc.EmployeeJpaRepository;
import com.example.demo.pojo.Employee;

@RestController
public class EmployeeJpaController {
	@Autowired
	EmployeeJpaRepository repo;
	
	@PostMapping("/employees-jpa")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		Employee e= repo.save(employee);
		return e;
	}
	
	@GetMapping("/employees-jpa/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
	{
		Optional<Employee> optional = repo.findById(id);
		if(optional.isPresent())
		{
			return new ResponseEntity<Employee>(optional.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/employees-jpa")
	public ResponseEntity<List<Employee>>getEmployees()
	{
		List<Employee> employees=repo.findAll();
		if(employees.size()>0)
		{
			return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
		}
		else
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/employees-jpa/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
		Optional<Employee> optional = repo.findById(id);
		if(optional.isPresent())
		{
			Employee employee = optional.get();
			repo.delete(employee);
			return new ResponseEntity<Employee>(optional.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/employees-jpa/{id}/{name}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @PathVariable String name) {
		Optional<Employee> optional = repo.findById(id);
		if(optional.isPresent())
		{
			Employee employee=optional.get();
			employee.setFirstName(name);
			return new ResponseEntity<Employee>(repo.save(employee),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/employees-jpa/salary/{salary}")
	public ResponseEntity<List<Employee>> getAllEmployeesBySalary(@PathVariable int salary)
	{
		List<Employee> optional = repo.findBySalary(salary);
		if(optional.size()>0)
		{
			return new ResponseEntity<List<Employee>>(optional,HttpStatus.OK);
		}
		else
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
	}
}
