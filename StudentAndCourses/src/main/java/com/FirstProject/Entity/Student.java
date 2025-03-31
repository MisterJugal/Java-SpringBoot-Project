package com.FirstProject.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;

	private String studentName;
	private int studentLevel;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "linking_table", joinColumns = {
			@JoinColumn(name = "student_id", referencedColumnName = "studentId") }, inverseJoinColumns = {
					@JoinColumn(name = "course_id", referencedColumnName = "courseId") })
	private List<Course> course;

	private int schoolId;
	private int homeId;
	
	@jakarta.persistence.Transient
	private School school;

	@jakarta.persistence.Transient
	private Home home;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentLevel() {
		return studentLevel;
	}

	public void setStudentLevel(int studentLevel) {
		this.studentLevel = studentLevel;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public int getHomeId() {
		return homeId;
	}

	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public Student(int studentId, String studentName, int studentLevel, List<Course> course, int schoolId, int homeId,
			School school, Home home) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentLevel = studentLevel;
		this.course = course;
		this.schoolId = schoolId;
		this.homeId = homeId;
		this.school = school;
		this.home = home;
	}

	public Student() {
		super();
	}


	
	
}
