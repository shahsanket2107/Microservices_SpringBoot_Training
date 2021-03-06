package com.hibernate_query_lang;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EmployeeDAOImpl implements EmployeeDAO{
	public Integer addEmployee(int id,String fname,String lname, int salary)
	{
		Integer employeeID = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee = new Employee(id,fname,lname,salary);
		employeeID=(Integer)session.save(employee);
		tx.commit();
		return employeeID;
	}

	@Override
	public List<Employee> listAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees= new ArrayList<Employee>();
		String FIND_ALL = "from com.hibernate_query_lang.Employee";
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(FIND_ALL);
		employees=query.getResultList();
		return employees;
	}

	@Override
	public List<Object[]> listAllEmployeesByCol() {
		// TODO Auto-generated method stub
		List<Object[]> objects= new ArrayList<>();
		String FIND_ALL = "select emp.id as emp_id,emp.firstName as emp_name from com.hibernate_query_lang.Employee emp";
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(FIND_ALL);
		objects = query.getResultList();
		return objects;
	}

	@Override
	public List<Object[]> listAllEmployeesByCol(int salary) {
		List<Object[]> objects= new ArrayList<>();
		String FIND_ALL = "select emp.id as emp_id,emp.firstName as emp_name from com.hibernate_query_lang.Employee emp where emp.salary=:sal";
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		TypedQuery<Object[]> query = session.createQuery(FIND_ALL);
		query.setParameter("sal",salary);
		objects = query.getResultList();
		return objects;
	}

	@Override
	public int updateEmployee(int salary, int id) {
		// TODO Auto-generated method stub
		int rows=0;
		List<Object[]> objects= new ArrayList<>();
		String UPDATE = "update com.hibernate_query_lang.Employee set salary=:sal where id=:empid";
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		TypedQuery<Object[]> query = session.createQuery(UPDATE);
		query.setParameter("sal",salary);
		query.setParameter("empid",id);
		rows = query.executeUpdate();
		tx.commit();
		return rows;
	}

	@Override
	public List<Employee> query() {
		// TODO Auto-generated method stub
		List<Employee> employees= new ArrayList<Employee>();
		//String FIND_ALL = "from com.hibernate_query_lang.Employee";
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("get_employees");
		employees=query.getResultList();
		return employees;
	}

	@Override
	public List<Object[]> mult_qury_with_param() {
		// TODO Auto-generated method stub
		List<Object[]> objects= new ArrayList<>();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("get_employees_sal");
		query.setParameter("sal", 3000);
		objects=query.getResultList();
		return objects;
	}
}
