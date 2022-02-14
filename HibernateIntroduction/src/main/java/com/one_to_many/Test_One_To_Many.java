package com.one_to_many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Test_One_To_Many {
	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();
		try {
			SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			List<Address_One_to_Many> addresses = new ArrayList<>();
			addresses.add(new Address_One_to_Many(4, 12340l, "pune"));
			addresses.add(new Address_One_to_Many(5, 12341l, "Banglore"));

			Person_One_to_Many person = 
					new Person_One_to_Many(14, "person name1", addresses);
			session.save(person);
			session.getTransaction().commit();


			session.close();
			sessionFactory.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}
}
