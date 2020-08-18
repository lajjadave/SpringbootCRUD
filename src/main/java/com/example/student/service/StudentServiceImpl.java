package com.example.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	@Override
	public List<Student> get() {
		return studentRepository.get();
	}

	@Override
	public Student get(int id) {
		return studentRepository.get(id);
	}

	@Transactional
	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}

	@Transactional
	@Override
	public void delete(int id) {
		studentRepository.delete(id);
	}

}
