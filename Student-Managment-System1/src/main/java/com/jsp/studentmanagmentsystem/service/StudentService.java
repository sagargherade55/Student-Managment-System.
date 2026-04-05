package com.jsp.studentmanagmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jsp.studentmanagmentsystem.entity.Admin;
import com.jsp.studentmanagmentsystem.entity.Student;

public interface StudentService {

	public Student save(Student student);
	public List<Student> saveAll(List<Student> students);
	public List<Student> viewAll();
	public Optional<Student> getByID(String id);
	public Student deleteByID(String id);
}
