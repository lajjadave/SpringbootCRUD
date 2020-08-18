package com.example.student.service;

import java.util.List;

import com.example.student.model.Student;

public interface StudentService {
	List<Student> get();
	
	Student get(int id);
	
	void save(Student student);
	
	void delete(int id);

}
