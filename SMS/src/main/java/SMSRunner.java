import java.util.List;
import java.util.Scanner;

import jpa.dao.CourseDAO;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.entitymodels.StudentCourse;

public class SMSRunner {
	private Scanner scanner;
	private CourseDAO courseDao;
	private StudentDAO studentDao;
	private Student currentStudent;

	public SMSRunner() {
		scanner = new Scanner(System.in);
		courseDao = new CourseDAO();
		studentDao = new StudentDAO();
	}

	// hluckham0@google.ru
	// X1uZcoIh0dj
	
	// sbowden1@yellowbook.com
	// SJc4aWSU
	
	public static void main(String[] args) {
		SMSRunner sms = new SMSRunner();

		try {
			int selection = sms.systemMenu();
			if (selection == 1) {
				if (sms.studentLogin()) {
					sms.registerMenu();
				}
			} else if (selection == 2) {
				System.out.println("\nGoodbye!");
			} else {
				System.out.println("\nWrong number. Please relaunch and input correct number.\n");
			}
		} catch (Exception e) {
			System.out.println("\nWrong input. Please relaunch and make sure the input is correct.\n");
			e.printStackTrace();
		} finally {
			sms.scanner.close();
		}

	}

	private int systemMenu() {
		System.out.println("Welcome to School Management System!\n");
		System.out.println("1. Student Login");
		System.out.println("2. Quit Application");
		System.out.println("\nPlease Enter Your Selection 1 or 2: ");
		int selection = scanner.nextInt();
		return selection;
	}

	private boolean studentLogin() {
		System.out.println("\nEnter your email address: ");
		String email = scanner.next();
		System.out.println("\nEnter your password: ");
		String password = scanner.next();

		boolean validation = studentDao.validateStudent(email, password);
		if (validation) {
			currentStudent = studentDao.getStudentByEmail(email);
			List<StudentCourse> studentCourses = studentDao.getStudentCourses(email);
			if (studentCourses.size() == 0) {
				System.out.println("\nYou haven't registered any classes yet.\n");
			} else {
				printMyClasses(studentCourses);
			}
		} else {
			System.out.println("\nWrong credentials. User Validation failed. GoodBye!\n");
		}
		return validation;
	}

	private void registerMenu() {
		System.out.println("1. Register a class");
		System.out.println("2. Logout");
		System.out.println("\nPlease Enter Your Selection 1 or 2:");
		int selection = scanner.nextInt();
		
		if (selection == 1) {
			List<Course> allCourses = courseDao.getAllCourses();
			System.out.printf("%n%-10s%-30s%-15s%n%n", "ID", "Course", "Instructor");
			for (Course course : allCourses) {
				System.out.printf("%-10s%-30s%-15s%n", course.getCId(), course.getCName(), course.getCInstructorName());
			}

			System.out.println("\nEnter Course Number to Register: ");
			int number = scanner.nextInt();
			Course newCourse = courseDao.getCourseById(number);
			if (newCourse != null) {
				studentDao.registerStudentToCourse(currentStudent.getSEmail(), newCourse);
				List<StudentCourse> studentCourses = studentDao.getStudentCourses(currentStudent.getSEmail());
				printMyClasses(studentCourses);
				System.out.println("GoodBye!");
			}
		} else if (selection == 2) {
			currentStudent = null;
			System.out.println("You have been logged out. GoodBye!");
		} else {
			System.out.println("Wrong input. Goodbye!");
		}
	}

	private void printMyClasses(List<StudentCourse> studentCourses) {
		System.out.println("\nMy Classes:");
		System.out.printf("%n%-10s%-30s%-15s%n%n", "ID", "Course", "Instructor");
		for (StudentCourse sc : studentCourses) {
			Course course = courseDao.getCourseById(sc.getCourseId());
			System.out.printf("%-10s%-30s%-15s%n", sc.getCourseId(), course.getCName(), course.getCInstructorName());
		}
		System.out.println();
	}
}
