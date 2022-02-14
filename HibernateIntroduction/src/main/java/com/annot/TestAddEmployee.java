package com.annot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestAddEmployee {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setId(32);
		employee.setFirstName("Billy");
		employee.setLastName("Joe");
		employee.setSalary(222);
		
		session.save(employee);
		
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
