package com.jsp.studentmanagmentsystem.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
		return new ResponseEntity<>(studentService.view(), HttpStatusCode.valueOf(200));
	}
}
