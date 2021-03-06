package com.annot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetEmployee {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = session.get(Employee.class,2);
		System.out.println("Value of Employee is :"+employee);
		
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
