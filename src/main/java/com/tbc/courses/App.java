package com.tbc.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 * 
 */
public class App {
	public static List<Course> getCourses(){
		List<Course> courses=new ArrayList<Course>();
		Random random = new Random();

		Teacher[] teachers = new Teacher[] { new Teacher("Stefan Wehner"),
				new Teacher("Perico de los palotes"), new Teacher("RMS") };

		String[] course_names = new String[] { "OOP1", "OOP2", "MTP1", "MTP2",
				"MTP3", "HS1", "HS2", "HS3", "HS4", "Gañanismo 1",
				"Gañanismo 2" };

		Level[] levels = Level.values();
		for (String course_name : course_names) {
			Course course = new Course();
			course.setTitle(course_name);
			course.setTeacher(teachers[random.nextInt(teachers.length)]);
			course.setActive(random.nextInt(100) > 25);
			course.setHours(random.nextInt(100));
			course.setLevel(levels[random.nextInt(levels.length)]);
			courses.add(course);
		}
		return courses;
	}
	
	public static void populate(EntityManager entityManager) {
		List<Course> courses = getCourses();
		for (Course c : courses) {
			entityManager.persist(c);
			entityManager.persist(c.getTeacher());
		}
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("com.tbc.courses.jpa");

		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();

		// populate(entityManager);

		entityManager.getTransaction().commit();

		List<Course> result = entityManager.createQuery("from Course",
				Course.class).getResultList();
		for (Course course : result) {
			System.out.println(course + " : " + course.getTeacher());
			// System.out.println("Courses: " +
			// course.getTeacher().getCourses());
		}

		entityManager.close();
	}
}
