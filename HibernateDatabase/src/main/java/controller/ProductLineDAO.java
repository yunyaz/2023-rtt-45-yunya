package controller;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.ProductLine;

public class ProductLineDAO {

	public void insert(ProductLine productLine) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.save(productLine);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	public void update(ProductLine productLine) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.merge(productLine);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	public void delete(ProductLine productLine) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.delete(productLine);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	
	public ProductLine findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM ProductLine pl where pl.id = :idParam";
		TypedQuery<ProductLine> query = session.createQuery(hql,ProductLine.class);
		query.setParameter("idParam", id);
		ProductLine result = query.getSingleResult();
		
		session.close();
		factory.close();
		
		return result;
	}
}
