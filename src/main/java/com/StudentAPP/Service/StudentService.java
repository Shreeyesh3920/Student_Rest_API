package com.StudentAPP.Service;

import java.util.List;

import com.StudentAPP.Payloads.StudentDTO;

public interface StudentService {

	
	public StudentDTO createStudent(StudentDTO studentdto);
	
	public StudentDTO getUserById(Integer studentID);
	
	public List<StudentDTO> getAllStudents();
	
	public StudentDTO updateStudent(Integer studentID, StudentDTO studentdto);
	
	public void deleteStudent(Integer studentID);
	
	
	
}
