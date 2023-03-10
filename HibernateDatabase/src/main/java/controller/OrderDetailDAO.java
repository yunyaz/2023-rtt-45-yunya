package controller;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.OrderDetail;

public class OrderDetailDAO {

	public void insert(OrderDetail orderDetail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.save(orderDetail);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	public void update(OrderDetail orderDetail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.merge(orderDetail);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	public void delete(OrderDetail orderDetail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.delete(orderDetail);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	
	public OrderDetail findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM OrderDetail od where od.id = :idParam";
		TypedQuery<OrderDetail> query = session.createQuery(hql,OrderDetail.class);
		query.setParameter("idParam", id);
		OrderDetail result = query.getSingleResult();
		
		session.close();
		factory.close();
		
		return result;
	}
}
