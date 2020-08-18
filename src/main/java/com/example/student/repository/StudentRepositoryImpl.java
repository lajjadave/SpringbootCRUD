package com.example.student.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.student.model.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Student> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Student> query = currentSession.createQuery("from Student", Student.class);
		List<Student> list = query.getResultList();
		return list;
	}

	@Override
	public Student get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Student student = currentSession.get(Student.class, id);
		return student;
	}

	@Override
	public void save(Student student) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(student);
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Student student = currentSession.get(Student.class, id);
		currentSession.delete(student);
	}

}
