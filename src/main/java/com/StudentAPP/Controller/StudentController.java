package com.StudentAPP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.StudentAPP.Payloads.*;
import com.StudentAPP.Service.StudentService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
@RestController
@RequestMapping("/api/students")
@Validated
public class StudentController {
	@Autowired
	StudentService studentservice;
	
	@PostMapping("/")
	public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody  StudentDTO studentdto)
	{
		StudentDTO studentDTO=this.studentservice.createStudent(studentdto);
		return new ResponseEntity<StudentDTO>(studentDTO,HttpStatus.CREATED);
	}
	
	@GetMapping("/{studentID}")
	public ResponseEntity<StudentDTO> getStudentByID(@PathVariable @Positive(message="StudentID must be Positive") Integer studentID)
	{
		StudentDTO studentDTO=this.studentservice.getUserById(studentID);
		return new ResponseEntity<StudentDTO>(studentDTO,HttpStatus.FOUND);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<StudentDTO>> getStudents()
	{
		List<StudentDTO> studentdto=this.studentservice.getAllStudents();
		return new ResponseEntity<>(studentdto,HttpStatus.FOUND);
	}
	
	@PutMapping("/{studentID}")
	public ResponseEntity<StudentDTO> updateStudent(@PathVariable @Positive(message="StudentID must be Positive") Integer studentID ,@Valid @RequestBody StudentDTO studentdto)
	{
		StudentDTO studentDTO=this.studentservice.updateStudent(studentID, studentdto);
		return new ResponseEntity<>(studentDTO,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/{studentID}")
	public ResponseEntity<ApiResponses> deleteStudentByID(@PathVariable @Positive(message="StudentID must be Positive") Integer studentID)
	{
		this.studentservice.deleteStudent(studentID);
		return new ResponseEntity<>(new ApiResponses("Student Deleted Successfully",true),HttpStatus.FOUND);
	}
}
