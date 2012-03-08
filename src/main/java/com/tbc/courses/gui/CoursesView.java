package com.tbc.courses.gui;

import java.util.List;

import com.tbc.courses.App;
import com.tbc.courses.Course;

public class CoursesView {
	public List<Course> getCourses(){
		return App.getCourses();
	}
}
