package com.SchoolDetails.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SchoolDetails.Entities.School;
import com.SchoolDetails.Repositories.SchoolRepo;
import com.SchoolDetails.Service.SchoolService;

@Component
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	private SchoolRepo schoolRepo;

	@Override
	public List<School> getAllSchools() {

		return schoolRepo.findAll();		
	}

	@Override
	public School addSchool(School school) {
		return schoolRepo.save(school);
		
	}

	@Override
	public School getSchoolById(int schoolId) {
		
		Optional<School> opt=schoolRepo.findById(schoolId);
		
		if(opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public School updateSchool(School school, int schoolId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public School deleteSchoolById(int schoodId) {
		// TODO Auto-generated method stub
		return null;
	}

}
