package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class StudentService {
	@Autowired
	StudentRepository s;

	public String CreateStudent(StudentDetails st) {
		s.save(st);
		return "Student record created";
	}
	
	public StudentDetails UpdateStudent(StudentDetails st, int id) {
		if(!s.existsById(id))throw new StudentNotFoundException(id);
		st.setId(id);
		return s.save(st);
	}

	public StudentDetails GetStudent(int id) {
		return s.findById(id).orElseThrow(()->new StudentNotFoundException(id));
	}
	
	public String DeleteStudent(int id) {
		s.findById(id).orElseThrow(()->new StudentNotFoundException(id));
		s.deleteById(id);
		return "Student record deleted";
	}
}
