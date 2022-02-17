package com.example.demo.jdbc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Employee;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findBySalary(int salary);
	List<Employee> findBySalaryAndFirstName(int salary,String firstName);
}
