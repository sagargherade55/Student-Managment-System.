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

import com.jsp.studentmanagmentsystem.entity.Admin;
import com.jsp.studentmanagmentsystem.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping("/save")
	public ResponseEntity<Admin> save(@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.save(admin), HttpStatusCode.valueOf(201));
	}
	
	@GetMapping("/view")
	public ResponseEntity<List<Admin>> viewAll(){
		return new ResponseEntity<>(adminService.view(), HttpStatusCode.valueOf(200));
	}
}
