package com.StudentAPP.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Student_Table")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int student_ID;
	private String student_Name;
	private String student_Address;
	private int student_Age;
	private String gender;
	private String email_ID;
	private int phone_Number;
	
}
