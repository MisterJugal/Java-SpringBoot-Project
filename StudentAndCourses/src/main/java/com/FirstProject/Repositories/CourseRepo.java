package com.FirstProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FirstProject.Entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer>{

}
