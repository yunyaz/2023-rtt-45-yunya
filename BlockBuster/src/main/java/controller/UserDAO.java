package controller;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class UserDAO {

	public void insert(User user) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	public void update(User user) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.merge(user);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	public void delete(User user) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	public User findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM User u where u.id = :idParam";
		TypedQuery<User> query = session.createQuery(hql, User.class);
		query.setParameter("idParam", id);
		User result = query.getSingleResult();

		session.close();
		factory.close();

		return result;
	}

}
