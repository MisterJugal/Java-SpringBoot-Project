package com.FirstProject.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;

	private String studentName;
	private int studentLevel;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "linking_table", joinColumns = {
			@JoinColumn(name = "student_id", referencedColumnName = "studentId") }, inverseJoinColumns = {
					@JoinColumn(name = "course_id", referencedColumnName = "courseId") })
	private List<Course> course;

	private int schoolId;
	private int homeId;
	
	@jakarta.persistence.Transient
	private School school;

	@jakarta.persistence.Transient
	private Home home;


}
