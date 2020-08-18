package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student")
	public List<Student> get(){
		return studentService.get();
	}
	
	@PostMapping("/student")
	public Student save(@RequestBody Student student) {
		studentService.save(student);
		return student;
	}
	
	@GetMapping("/student/{id}")
	public Student get(@PathVariable int id) {
		Student student = studentService.get(id);
		if(student == null) {
			throw new RuntimeException("Student with id "+id+" is not found");
		}
		return student;
	}
	
	@DeleteMapping("/student/{id}")
	public void delete(@PathVariable int id) {
		studentService.delete(id);
	}
	
	@PutMapping("/student")
	public Student update(@RequestBody Student student) {
		studentService.save(student);
		return student;
	}
}
