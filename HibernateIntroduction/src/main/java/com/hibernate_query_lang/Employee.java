package com.hibernate_query_lang;
import javax.persistence.*;
@NamedQuery(name="get_employees",query="from com.hibernate_query_lang.Employee")
@NamedQueries({
	@NamedQuery(name="get_employees_multi",query="from com.hibernate_query_lang.Employee"),
	@NamedQuery(name="get_employees_sal",query="select emp.id as emp_id,emp.firstName as emp_name from com.hibernate_query_lang.Employee emp where emp.salary=:sal")
})
@Entity(name="hql")
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
	public Employee(int id, String firstName, String lastName, int salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
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
