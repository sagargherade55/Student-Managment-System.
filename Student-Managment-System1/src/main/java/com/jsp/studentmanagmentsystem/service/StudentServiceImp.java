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

	@Override
	public Student updateFullObj(String id, Student student) {
		Optional<Student> optional = getByID(id);
		if (optional.isEmpty()) throw new ResoueseNotFoundException("Resourse not present in DB");
		
		Student student2 = optional.get();
		student2.setBranch(student.getBranch());
		student2.setCollege(student.getCollege());
		student2.setContact(student.getContact());
		student2.setDob(student.getDob());
		student2.setEmail(student.getEmail());
		student2.setName(student.getName());
		student2.setPrn(student.getPrn());
		return repo.save(student2);
	}

	@Override
	public Student findStudentByContact(String contact) {
		Optional<Student> byContact = repo.findByContact(contact);
		System.out.println("student found :"+byContact);
		if (byContact.isEmpty()) throw new ResoueseNotFoundException("Student not Present in BD");
			Student student = byContact.get();
			return student;
	}

}
