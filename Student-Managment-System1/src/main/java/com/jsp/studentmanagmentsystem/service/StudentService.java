package com.jsp.studentmanagmentsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jsp.studentmanagmentsystem.entity.Student;

public interface StudentService {

	public Student save(Student student);
	public List<Student> saveAll(List<Student> students);
	public List<Student> view();
}
