package com.tbc.courses;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Course {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	private String title;
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	private Integer hours;
	@Enumerated(EnumType.STRING)
	private Level level;
	private Boolean active;

	public Course(){
		
	}
	
	public Course(String title, Teacher teacher, Integer hours, Level level,
			boolean active) {
		super();
		this.title = title;
		this.teacher = teacher;
		this.hours = hours;
		this.level = level;
		this.active = active;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
		teacher.getCourses().add(this);
	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Course [title=" + title + ", hours=" + hours + ", level="
				+ level + ", active=" + active + "]";
	}
}
