package jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.entitymodels.StudentCourse;

public class StudentDAO {
	
	public List<Student> getAllStudents() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Student";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		List<Student> result = query.getResultList();
		
		session.close();
		factory.close();
		return result;
	}

	public Student getStudentByEmail(String email) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Student s WHERE s.sEmail = :emailParam";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("emailParam", email);
		Student result = query.getSingleResult();
		
		session.close();
		factory.close();
		return result;
	}

	public boolean validateStudent(String email, String password) {
		Student student = getStudentByEmail(email);
		if (student != null && student.getSPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public void registerStudentToCourse(String email, Course newCourse) {
		Student student = getStudentByEmail(email);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		List<StudentCourse> courses = student.getSCourses();
		for (StudentCourse sc : courses) {
			if (sc.getCourseId() == newCourse.getCId()) {
				System.out.println("\nYou are already registered in that course.");
				session.close();
				factory.close();
				return;
			}
		}
		StudentCourse newSC = new StudentCourse();
		newSC.setStudent(student);
		newSC.setCourse(newCourse);
		System.out.println("\nYou have registered the class successfully.");
		
		session.getTransaction().begin();
		session.save(newSC);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	public List<StudentCourse> getStudentCourses(String email) {
		Student student = getStudentByEmail(email);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		List<StudentCourse> result = student.getSCourses();
		
		session.close();
		factory.close();
		return result;
	}
}
