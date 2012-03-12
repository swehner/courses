package com.tbc.courses;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("coursesService")
@Repository
public class JpaCoursesService implements CoursesService, Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Course> findCourses(ListCriteria crit) {
		String sortDir="desc";
		if (crit!=null){
			if (crit.getSortAsc())
				sortDir="asc";
		}
			
		return em.createQuery("from Course order by title " + sortDir, Course.class).getResultList();
	}

	@Override
	@Transactional
	public void persistCourse(Course course) {
		em.persist(course);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Teacher> getTeachers() {
		return em.createQuery("from Teacher", Teacher.class).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Level> getLevels() {
		return Arrays.asList(Level.values());
	}

	@Override
	public Teacher findTeacher(Long id) {
		Teacher result = em
				.createQuery("select t from Teacher t where t.id = :id", Teacher.class)
				.setParameter("id", id).getSingleResult();
		return result;
	}
}