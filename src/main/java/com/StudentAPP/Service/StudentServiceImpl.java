package com.StudentAPP.Service;

import java.util.LinkedList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentAPP.Entity.Student;
import com.StudentAPP.Exceptions.ResourceNotFoundException;
import com.StudentAPP.Payloads.StudentDTO;
import com.StudentAPP.Repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private ModelMapper modelmapper;
	@Autowired
	private StudentRepo studentrepo;
	
	@Override
	public StudentDTO createStudent(StudentDTO studentdto) {

		Student savedstudent=this.modelmapper.map(studentdto,Student.class);
		this.studentrepo.save(savedstudent);
		return this.modelmapper.map(savedstudent, StudentDTO.class);
	}

	@Override
	public StudentDTO getUserById(Integer studentID) {
		Student student=this.studentrepo.findById(studentID).orElseThrow(()-> new ResourceNotFoundException("Student","studentID",studentID));
		
		return this.modelmapper.map(student, StudentDTO.class);
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student> list_Student=this.studentrepo.findAll();
		List<StudentDTO> list_Student_DTO=new LinkedList<>();
		
		for(Student student:list_Student) 
		{
			list_Student_DTO.add(this.modelmapper.map(student, StudentDTO.class));
		}
		return list_Student_DTO;
	}

	@Override
	public StudentDTO updateStudent(Integer studentID,StudentDTO studentdto) {
		Student student=this.studentrepo.findById(studentID).orElseThrow(()-> new ResourceNotFoundException("Student","studentID",studentID));
		student.setStudent_Name(studentdto.getStudent_Name());
		student.setEmail_ID(studentdto.getEmail_ID());
		student.setStudent_Age(studentdto.getStudent_Age());
		student.setStudent_Address(studentdto.getStudent_Address());
		student.setGender(studentdto.getGender());
		student.setPhone_Number(studentdto.getPhone_Number());
		
		this.studentrepo.save(student);
		
		return this.modelmapper.map(student, StudentDTO.class);
	}

	@Override
	public void deleteStudent(Integer studentID) {
		Student student=this.studentrepo.findById(studentID).orElseThrow(()-> new ResourceNotFoundException("Student","studentID",studentID));
		this.studentrepo.deleteById(studentID);
		
	}

	

}
