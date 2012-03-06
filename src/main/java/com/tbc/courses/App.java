package com.tbc.courses;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.tbc.courses.jpa");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
//		Course course = new Course("OOP1");
//		Teacher teacher = new Teacher("Stefan Wehner");
//		course.setTeacher(teacher);
//		
//		System.out.println(teacher.getCourses());
//		entityManager.persist(course);
//		entityManager.persist(teacher);
//		entityManager.getTransaction().commit();

		
		List<Course> result = entityManager.createQuery("from Course",
		Course.class).getResultList(); for (Course course : result) {
		System.out.println(course + " : " + course.getTeacher());
		System.out.println("Courses: " + course.getTeacher().getCourses()); }
		 
		entityManager.close();
	}
}
