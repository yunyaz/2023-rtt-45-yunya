package controller;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.MovieRental;

public class MovieRentalDAO {

	public void insert(MovieRental movieRental) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.save(movieRental);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	public void update(MovieRental movieRental) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.merge(movieRental);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	public void delete(MovieRental movieRental) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.delete(movieRental);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	public MovieRental findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM MovieRental o where o.id = :idParam";
		TypedQuery<MovieRental> query = session.createQuery(hql, MovieRental.class);
		query.setParameter("idParam", id);
		MovieRental result = query.getSingleResult();

		session.close();
		factory.close();

		return result;
	}

}
