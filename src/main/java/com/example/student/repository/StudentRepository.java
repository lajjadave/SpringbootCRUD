package com.example.student.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.student.model.Student;

@Repository
public interface StudentRepository {
	List<Student> get();
	
	Student get(int id);
	
	void save(Student student);
	
	void delete(int id);
	

}
