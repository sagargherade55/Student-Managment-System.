package com.jsp.studentmanagmentsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.studentmanagmentsystem.entity.Student;
import com.jsp.studentmanagmentsystem.repo.StudentRepo;

@Service
public class StudentServiceImp implements StudentService{
	
	@Autowired
	StudentRepo repo;

	@Override
	public Student save(Student student) {
		
		return repo.save(student);
	}

}
