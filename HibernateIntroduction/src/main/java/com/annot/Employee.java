package com.annot;
import javax.persistence.*;

@Entity(name="myemp")
public class Employee {
	@Id
	@Column(name="empid")
	//@GeneratedValue(strategy=GenerationType.AUTO);
	private int id;
	private String firstName;
	private String lastName;
	private int salary;
	
	public Employee()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ "]";
	}
	
	
}
