package com.FirstProject.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.FirstProject.Entity.School;
import com.FirstProject.Entity.Student;
import com.FirstProject.ExternalServices.HomeService;
import com.FirstProject.Repositories.StudentRepo;
import com.FirstProject.Service.StudentService;

@Component
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private HomeService homeService;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Student> getAllStudents() {

		List<Student> students=studentRepo.findAll();

		for(Student s:students)
		{
			School school=restTemplate.getForEntity("http://SCHOOL-SERVICE/school/getSchool/"+s.getSchoolId(), School.class).getBody();
			

			s.setHome(homeService.getHomeById(s.getHomeId()).getBody());
			s.setSchool(school);
		}	

		return students;
	}
	
	

	@Override
	public Student getStudentById(int studentId) {

		List<Student> list = studentRepo.findAll();

		for (Student std : list) {
			if (std.getStudentId() == studentId)
			{
				//Manualing adding a school

				// School school=new School();
				// school.setSchoolAddress("Gauchar Dwarahat");
				// school.setSchoolAge("10 Years");
				// school.setSchoolId(23);
				// school.setSchoolName("KPS DWARAHAT");
				// std.setSchool(school);


				//Fetching school details from anothe microservice

				School school=restTemplate.getForEntity("http://SCHOOL-SERVICE/school/getSchool/"+std.getSchoolId(), School.class).getBody();

				std.setHome(homeService.getHomeById(std.getHomeId()).getBody());
				std.setSchool(school);



				
				return std;
			}
				
		}

		return null;

	}

	@SuppressWarnings("null")
	public Student addStudent(Student student) {

		Student std = null;
		try {
			// System.out.println("Before setting SchoolID: "+student.toString());

			//saving data on School service using rest template and setting the schoolId on the student which was created on the database while saving the school
			student.setSchoolId(restTemplate.postForEntity("http://SCHOOL-SERVICE/school/addSchool",student.getSchool(),School.class).getBody().getSchoolId());

			//saving data on home service using feign client and setting the homeId on the student which was created on the database while saving the home
			student.setHomeId(homeService.addHome(student.getHome()).getBody().getHomeId());
			//System.out.println("After setting SchoolId: "+student.toString());
			studentRepo.save(student);
			return studentRepo.getReferenceById(student.getStudentId());
		}

		catch (Exception e) {
			e.printStackTrace();
			return std;
		}

	}
	
	public List<Student> addMultipleStudents(List<Student> students)
	{
		for(Student s:students)
		{
			addStudent(s);
		}


		return students;
	}

	public String updateStudent(int id, Student student) {

		Student oldStudent = null;
		List<Student> list = studentRepo.findAll();

		for (Student std : list) {
			if (std.getStudentId() == id)
				oldStudent = std;

		}

		if(oldStudent==(null))	
			return null;
		
		try {
			oldStudent.setStudentLevel(student.getStudentLevel());
		oldStudent.setStudentName(student.getStudentName());

		studentRepo.save(oldStudent);

		return oldStudent.getStudentName() + " updated";
		}
		catch (Exception e) {
			return null;
		}
	}
	
	

	public String deleteAllStudents() {
		
		try {
			
		studentRepo.deleteAll();
		return "All student data removed";
		}
		catch (Exception e) {
			return null;
		}
	}
	
	

	public Student deleteStudent(int studentId) {
		List<Student> list = studentRepo.findAll();

		Student student=null;
		for (Student std : list) {
			if (std.getStudentId() == studentId) {
				student=std;
				studentRepo.delete(std);
			}

		}
		
		return student;
	}

	
	public boolean validationCheck(Student student) {

		if (student.getStudentLevel() == 0 || student.getStudentName() == null)
			return false;
		else
			return true;
	}

}
