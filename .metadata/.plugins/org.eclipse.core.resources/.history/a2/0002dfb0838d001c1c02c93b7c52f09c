package com.pojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDeleteEmployee {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		/*
		 * Employee employee = new Employee(); employee.setId(1);
		 * employee.setFirstName("sanket shah"); employee.setLastName("shah");
		 * employee.setSalary(400);
		 */

		Employee employee = session.get(Employee.class, 22);
		if(employee!=null)
		{
			session.delete(employee);
		}
		else
		{
			System.out.println("No record exists!!");
		}
		

		System.out.println("Value of Employee is :"+employee);
		
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}

