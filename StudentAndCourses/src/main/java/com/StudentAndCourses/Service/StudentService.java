package com.StudentAndCourses.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.StudentAndCourses.Entity.Student;

import jakarta.servlet.http.HttpServletRequest;
@Component
public interface StudentService{


	public List<Student> getAllStudents(HttpServletRequest request);
	public Student getStudentById(int studentId,HttpServletRequest request);
	public Student addStudent(Student student);
	public String updateStudent(int studentId,Student student);
	public String deleteAllStudents();
	public Student deleteStudent(int studentId);
	public boolean validationCheck(Student student);
	public List<Student> addMultipleStudents(List<Student> students);
}
