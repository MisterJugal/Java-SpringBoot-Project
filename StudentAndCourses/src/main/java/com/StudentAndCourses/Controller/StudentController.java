package com.StudentAndCourses.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentAndCourses.Entity.Student;
import com.StudentAndCourses.Service.StudentService;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@SuppressWarnings("null")
	@GetMapping("/adminView")
	public ResponseEntity<List<Student>> adminViewOfStudents(HttpServletRequest request) {
		List<Student> students = studentService.getAllStudents(request);

		if (students.isEmpty())

			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@SuppressWarnings("null")
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(HttpServletRequest request) {
		List<Student> students = studentService.getAllStudents(request);

		if (students.isEmpty())

			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@SuppressWarnings("null")
	@GetMapping("/student/{studentId}")
	public ResponseEntity<Student> getStudentByID(@PathVariable int studentId, HttpServletRequest request) {
		Student student = studentService.getStudentById(studentId,request);

		if (student.equals(null))
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	

	@SuppressWarnings("null")
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {

		// String confirmation = "Student added";
		// String failure = "Could not add student";
		// String invalidData="Entered data is invalid";

		boolean validationCheck = studentService.validationCheck(student);
		if (validationCheck) {

			
			
			Student std = studentService.addStudent(student);

			if (std==null)
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

			return new ResponseEntity<>(std, HttpStatus.CREATED);
		}
		
		else
		{
			return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
		}

	}
	
	@PostMapping("/addMultipleStudents")
	public ResponseEntity<List<Student>> addMultipleStudents(@RequestBody List<Student> student)
	{
		return new ResponseEntity<>(studentService.addMultipleStudents(student),HttpStatus.CREATED);

	}

	@PutMapping("/updateStudent/{studentId}")
	public ResponseEntity<String> updateStudent(@PathVariable int studentId, @RequestBody Student student) {
		String notFound="Student not found";
		
		if(studentService.updateStudent(studentId, student)==null)
			return new ResponseEntity<>(notFound,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<String>(student.getStudentName()+" updated",HttpStatus.OK);

	}
	
	

	@DeleteMapping("/deleteAllStudents")
	public ResponseEntity<String> deleteAllStudents() {
		
		String response=studentService.deleteAllStudents();
		if(response==null)
			return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_GATEWAY);
		
		return new ResponseEntity<>(response,HttpStatus.GONE);
	}

	
	
	@DeleteMapping("/deleteStudent/{studentId}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int studentId) {
		
		Student student=studentService.deleteStudent(studentId);
		
		if(student==null)
		{
			return new ResponseEntity<>(student,HttpStatus.NOT_FOUND);
		}
		
		else
		{
			return new ResponseEntity<>(student,HttpStatus.OK);
		}
	}

}
