package com.SchoolDetails.Controllers;

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

import com.SchoolDetails.Entities.School;
import com.SchoolDetails.Service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	@GetMapping("/getAllSchools")
	public ResponseEntity<List<School>> getAllSchools()
	{
		return new ResponseEntity<>(schoolService.getAllSchools(),HttpStatus.OK);
	}
	
	@GetMapping("/getSchool/{schoolId}")
	public ResponseEntity<School> getSchoolById(@PathVariable int schoolId)
	{
		return new ResponseEntity<>(schoolService.getSchoolById(schoolId),HttpStatus.OK);
	}

	@PostMapping("/addSchool")
	public ResponseEntity<School> addSchool(@RequestBody School school)
	{
		
		return new ResponseEntity<>(schoolService.addSchool(school),HttpStatus.CREATED);
	}
	
}
