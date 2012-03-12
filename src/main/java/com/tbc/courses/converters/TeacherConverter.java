package com.tbc.courses.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tbc.courses.CoursesService;
import com.tbc.courses.Teacher;


/**
 * Converter created by Spring with dependency injection - not managed by Faces
 * @author stefan
 *
 */
@Component("teacherConverter")
@Scope("request")
public class TeacherConverter implements javax.faces.convert.Converter {

	private final CoursesService coursesService;

	@Autowired
	public TeacherConverter(CoursesService coursesService) {
		this.coursesService = coursesService;
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Teacher findTeacher = coursesService.findTeacher(Long.parseLong(arg2));
		return findTeacher;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 instanceof Teacher) {
			Teacher teacher = (Teacher) arg2;
			return teacher.getId().toString();
		}
		return null;
	}

}
