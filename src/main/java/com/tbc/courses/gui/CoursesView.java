package com.tbc.courses.gui;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tbc.courses.App;
import com.tbc.courses.Course;

@Component
@Scope("request")
@Qualifier("coursesView")
public class CoursesView {
	private Course courseBacking;

	public CoursesView(){
		this.courseBacking = new Course();
	}
	
	public List<Course> getCourses(){
		return App.getCourses();
	}
	
	public String addCourse(){
		System.out.println("Add course");
		System.out.println(courseBacking);
		return null;
	}

	public Course getCourseBacking() {
		return courseBacking;
	}
}
