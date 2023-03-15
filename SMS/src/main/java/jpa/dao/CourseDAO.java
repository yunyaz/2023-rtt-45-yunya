package jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;

public class CourseDAO {
	
	public List<Course> getAllCourses() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Course";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		List<Course> result = query.getResultList();
		
		session.close();
		factory.close();
		return result;
	}
	
	public Course getCourseById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Course c where c.id = :idParam";
		TypedQuery<Course> query = session.createQuery(hql,Course.class);
		query.setParameter("idParam", id);
		Course result = query.getSingleResult();
		
		session.close();
		factory.close();
		return result;
	}
}
