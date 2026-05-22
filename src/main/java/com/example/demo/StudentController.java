package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
@RestController
public class StudentController {
	@Autowired
	StudentService ss;
	
	@PostMapping("/create")
	public String CreateStudent(@Valid @RequestBody StudentDetails st) {
		return ss.CreateStudent(st);
	}
	
	@PutMapping("/update/{id}")
	public StudentDetails UpdateStudent(@PathVariable int id, @Valid @RequestBody StudentDetails st) {
		return ss.UpdateStudent(st,id);
	}
	
	@GetMapping("/getStudent/{id}")
	public StudentDetails GetStudent(@PathVariable int id) {
		return ss.GetStudent(id);
	}
	
	@DeleteMapping("deletestudent/{id}")
	public String DeleteStudent(@PathVariable int id) {
		return ss.DeleteStudent(id);
	}
}
