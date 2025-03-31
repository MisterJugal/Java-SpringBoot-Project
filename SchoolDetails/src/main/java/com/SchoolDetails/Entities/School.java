package com.SchoolDetails.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@NoArgsConstructor
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int schoolId;
	private String schoolName;
	private String schoolAddress;
	private String schoolAge;

}
