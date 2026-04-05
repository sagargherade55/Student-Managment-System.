package com.jsp.studentmanagmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.studentmanagmentsystem.entity.Admin;
import com.jsp.studentmanagmentsystem.entity.Student;
import com.jsp.studentmanagmentsystem.exception.ResoueseNotFoundException;
import com.jsp.studentmanagmentsystem.repo.StudentRepo;

@Service
public class StudentServiceImp implements StudentService{
	
	@Autowired
	StudentRepo repo;

	@Override
	public Student save(Student student) {
		
		return repo.save(student);
	}

	@Override
	public List<Student> viewAll() {
		return repo.findAll();
	}

	@Override
	public List<Student> saveAll(List<Student> students) {
		return repo.saveAll(students);
	}

	@Override
	public Student deleteByID(String id) {
		Optional<Student> optional = getByID(id);
		if (optional.isEmpty()) throw new ResoueseNotFoundException("Object not present in DB");
		Student student = optional.get();
		repo.delete(student);
		return student;
	}

	@Override
	public Optional<Student> getByID(String id) {
		return repo.findById(id);
	}

}
