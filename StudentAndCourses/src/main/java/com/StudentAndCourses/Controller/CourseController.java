package com.StudentAndCourses.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentAndCourses.Entity.Course;
import com.StudentAndCourses.Service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	public CourseService courseService;
	
	@GetMapping("/getAllCourses")
	public ResponseEntity<List<Course>> getAllCourses()
	{
		List<Course> courses=courseService.getAllCourses();
		
		if(courses.isEmpty())
			return new ResponseEntity<>(courses,HttpStatus.NO_CONTENT);
		else 
			return new ResponseEntity<>(courses,HttpStatus.OK);
	}
	
	@GetMapping("/getCourseById/{courseId}")
	public ResponseEntity<Course> getCoursebyId(@PathVariable int courseId)
	{
		Course course=courseService.getCourseById(courseId);
		
		if(course==null)
			return new ResponseEntity<>(course,HttpStatus.NOT_FOUND);
		
		
		return new ResponseEntity<>(course,HttpStatus.OK);
	}

	
	@PostMapping("/addCourse")
	public ResponseEntity<Course> addCourse(@RequestBody Course course)
	{
		Course c=courseService.addCourse(course);
		if(c==null)
			return new ResponseEntity<>(c,HttpStatus.BAD_GATEWAY);
		
		
		return new ResponseEntity<>(course,HttpStatus.CREATED);
	}
}



















