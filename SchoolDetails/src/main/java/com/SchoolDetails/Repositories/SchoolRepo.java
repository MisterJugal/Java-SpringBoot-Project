package com.SchoolDetails.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SchoolDetails.Entities.School;

public interface SchoolRepo extends JpaRepository<School, Integer>{

}
