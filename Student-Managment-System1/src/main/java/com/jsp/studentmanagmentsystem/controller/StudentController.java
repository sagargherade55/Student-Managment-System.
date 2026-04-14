package com.jsp.studentmanagmentsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.studentmanagmentsystem.entity.Student;
import com.jsp.studentmanagmentsystem.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("save")
	public ResponseEntity<Student> save(@RequestBody Student student){
		return new ResponseEntity<>(studentService.save(student), HttpStatusCode.valueOf(201));
	}
	
	@GetMapping("/view")
	public ResponseEntity<List<Student>> viewAll(){
		return new ResponseEntity<>(studentService.viewAll(), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("/saveAll")
	public ResponseEntity<List<Student>> saveAll(@RequestBody List<Student> students){
		return new ResponseEntity<List<Student>>(studentService.saveAll(students), HttpStatusCode.valueOf(201));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Student>> getByID(@PathVariable("id") String id){
		return new ResponseEntity<Optional<Student>>(studentService.getByID(id), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteByID(@PathVariable("id") String id){
		return new ResponseEntity<Student>(studentService.deleteByID(id), HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateFullObj(@PathVariable("id") String id, @RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateFullObj(id, student), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/contact/{contact}")
	public ResponseEntity<Student> getByContact(@PathVariable("contact") String contact){
		System.out.println("contact: "+contact);
		return new ResponseEntity<Student>(studentService.findStudentByContact(contact), HttpStatusCode.valueOf(200));
	}
}
