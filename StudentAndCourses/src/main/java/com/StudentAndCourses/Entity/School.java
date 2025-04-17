package com.StudentAndCourses.Entity;

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
public class School {

	private int schoolId;
	private String schoolName;
	private String schoolAddress;
	private String schoolAge;

}
