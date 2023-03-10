package controller;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Employee;

public class EmployeeDAO {
	
	
	public void insert(Employee employee) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	public void update(Employee employee) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.merge(employee);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	public void delete(Employee employee) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	
	public Employee findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Employee e where e.id = :idParam";
		TypedQuery<Employee> query = session.createQuery(hql,Employee.class);
		query.setParameter("idParam", id);
		Employee result = query.getSingleResult();
		
		session.close();
		factory.close();
		
		return result;
	}
	
}
