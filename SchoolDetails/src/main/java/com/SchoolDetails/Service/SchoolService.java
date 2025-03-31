package com.SchoolDetails.Service;

import java.util.List;

import com.SchoolDetails.Entities.School;

public interface SchoolService {
	
	public List<School> getAllSchools();
	public School getSchoolById(int schoolId);
	public School addSchool(School school);
	public School updateSchool(School school, int schoolId);
	public School deleteSchoolById(int schoodId);

}
