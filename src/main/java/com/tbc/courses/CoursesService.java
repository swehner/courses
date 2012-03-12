package com.tbc.courses;

import java.util.List;

public interface CoursesService {

	public abstract List<Course> findCourses(ListCriteria crit);
	
	public abstract void persistCourse(Course course);

	public abstract List<Teacher> getTeachers();
	
	public abstract List<Level> getLevels();
	
	public abstract Teacher findTeacher(Long id);
}