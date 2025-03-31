package com.FirstProject.Service;

import java.util.List;

import com.FirstProject.Entity.Course;

public interface CourseService {

	public List<Course> getAllCourses();
	public Course getCourseById(int courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course,int courseID);
	public boolean deleteAllCourses();
	public Course deleteCourseById(int courseId);
}
