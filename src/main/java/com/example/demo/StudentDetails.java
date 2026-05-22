package com.example.demo;

import jakarta.validation.constraints.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentDetails {
	@Id
	int id;
	
	@NotBlank(message="name is required field")
	@Size(min=2, max=30, message="name must be in between 2-30 character")
	String name;
	
	@NotNull(message = "Marks are required")
	@Min(value = 0, message ="marks cannot be less than 0")
	@Max(value=100, message	="marks cannot excess 100")
	double marks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
}
