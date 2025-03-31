package com.FirstProject.Service;

import java.util.List;

import com.FirstProject.Entity.Student;

public interface StudentService{


	public List<Student> getAllStudents();
	public Student getStudentById(int studentId);
	public Student addStudent(Student student);
	public String updateStudent(int studentId,Student student);
	public String deleteAllStudents();
	public Student deleteStudent(int studentId);
	public boolean validationCheck(Student student);
	public List<Student> addMultipleStudents(List<Student> students);
}
