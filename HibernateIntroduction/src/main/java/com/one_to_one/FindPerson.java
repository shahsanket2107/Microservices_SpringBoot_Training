package com.one_to_one;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FindPerson {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Person_One_to_One obj = session.get(Person_One_to_One.class,22);
		System.out.println("****************");
		System.out.println(obj);
		System.out.println(obj.getAddress());
		System.out.println("****************");
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
