package com.FirstProject.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.FirstProject.Entity.Course;
import com.FirstProject.Repositories.CourseRepo;
import com.FirstProject.Service.CourseService;

@Component
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	public CourseRepo courseRepo;

	@Override
	public List<Course> getAllCourses() {
		
		return courseRepo.findAll();
		
		
	}

	@Override
	public Course getCourseById(int courseId) {
		
		List<Course> course=courseRepo.findAll();
		
		for(Course c:course)
		{
			if(c.getCourseId()==courseId)
			{
				System.out.println("inside if");
				return c;
			}
				
		}
		
		return null;
	}

	@Override
	public Course addCourse(Course course) {
		try {
			
		courseRepo.save(course);
		return course;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Course updateCourse(Course course, int courseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAllCourses() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Course deleteCourseById(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
