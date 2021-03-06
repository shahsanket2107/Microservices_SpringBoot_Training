package com.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Employee;

public class Test_Add_Person {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Address_One_to_One address = new Address_One_to_One(33, 380007L, "Ahmedabad");
		Person_One_to_One person = new Person_One_to_One(23, "name3", address);
		
		//session.save(address);
		session.save(person);
		
		transaction.commit();
		session.close();
		sessionFactory.close();

	}
}
