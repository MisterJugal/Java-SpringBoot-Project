package com.FirstProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FirstProject.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	

}
