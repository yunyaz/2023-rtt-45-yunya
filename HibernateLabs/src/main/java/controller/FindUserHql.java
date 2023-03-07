package controller;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class FindUserHql {

	// a) "FROM" clause
	public void findUser() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM User";
		TypedQuery query = session.createQuery(hql);
		List<User> results = query.getResultList();
		for (User u : results) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name: " + u.getFullname() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());
		}
	}

	// b) "SELECT" clause
	public void findUserSelect() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "SELECT u FROM User u";
		Query query = session.createQuery(hql);
		List<User> list = query.getResultList();
		for (User u : list) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name: " + u.getFullname() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());
		}
	}

	// c) "WHERE" Clause and "Order by" Clause
	public void getRecordbyId() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM User E WHERE E.id > 2 ORDER BY E.salary DESC";
		TypedQuery query = session.createQuery(hql);
		List<User> results = query.getResultList();
		for (User u : results) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullname() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());
		}
	}

	// d) "Multiple SELECT" Expressions
	public void getRecords() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		TypedQuery<Object[]> queryy = session.createQuery("SELECT U.salary, U.fullname FROM User AS U", Object[].class);
		List<Object[]> resultss = queryy.getResultList();
		for (Object[] a : resultss) {
			System.out.println("Salary: " + a[0] + ", City: " + a[1]);
		}
	}

	// e) Aggregate Function
	public void getmaxSalary() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "SELECT max(U.salary) FROM User U";
		TypedQuery query = session.createQuery(hql);
		Double result = (Double) query.getSingleResult();
		System.out.println(result);
	}

	// f) "Group By" clause and Aggregate function
	public void getmaxSalaryGroupBy() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "SELECT SUM(U.salary), U.city FROM User U GROUP BY U.city";
		TypedQuery query = session.createQuery(hql);
		List<Object[]> result = query.getResultList();
		for (Object[] o : result) {
			System.out.println("Total salary " + o[0] + " | city: " + o[1]);
		}
	}

	// g) Named Parameters Syntax
	public void NamedQueryExample() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM User u WHERE u.id = :id";
		TypedQuery query = session.createQuery(hql);
		query.setParameter("id", 2);
		List<User> result = query.getResultList();
		for (User u : result) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullname() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());
		}
	}

}
