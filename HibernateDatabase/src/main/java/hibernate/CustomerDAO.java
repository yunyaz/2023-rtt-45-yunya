package hibernate;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CustomerDAO {
	
	
	public void insert(Customer customer) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.save(customer);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	public void update(Customer customer) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.merge(customer);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	public void delete(Customer customer) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.delete(customer);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	public List<Customer> findByContactFirstName(String name) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Customer c where c.contactFirstname = :firstname";
		
		TypedQuery<Customer> query = session.createQuery(hql,Customer.class);
		
		query.setParameter("firstname", name);
		List<Customer> result = query.getResultList();
		
		session.close();
		factory.close();
		
		return result;
	}
	
	public Customer findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Customer c where c.id = :idParam";
		TypedQuery<Customer> query = session.createQuery(hql,Customer.class);
		query.setParameter("idParam", id);
		Customer result = query.getSingleResult();
		
		session.close();
		factory.close();
		
		return result;
	}
	
	
	public void deleteById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "Delete FROM Customer c where c.id = :idParam";
		Query query = session.createQuery(hql);
		query.setParameter("idParam", id);
		
		session.getTransaction().begin();
		query.executeUpdate();
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}
	
}
