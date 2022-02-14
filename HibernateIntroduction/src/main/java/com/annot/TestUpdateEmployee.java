package com.annot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestUpdateEmployee {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

//		Employee employee = new Employee();
//		employee.setId(1);
//		employee.setFirstName("sanket shah");
//		//employee.setLastName("shah");
//		employee.setSalary(400);
		
//		Employee employee = session.get(Employee.class, 3);
//		if(employee!=null)
//		{
//			employee.setSalary(9999);
//			//employee.setLastName("Jr.");
//			employee.setFirstName("Robert Downey");
//			session.update(employee);
//		}
//		else
//		{
//			System.out.println("No record exists!!");
//		}
		
		Employee employee = new Employee();
		employee.setId(22);
		employee.setFirstName("Jimmy");
		session.saveOrUpdate(employee);
		System.out.println("Value of Employee is :"+employee);
		
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
