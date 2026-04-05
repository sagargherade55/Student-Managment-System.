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
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Admin>> view(@PathVariable("id") int id){
		return new ResponseEntity<Optional<Admin>>(adminService.getByID(id),HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/view")
	public ResponseEntity<List<Admin>> viewAll(){
		return new ResponseEntity<>(adminService.viewAll(), HttpStatusCode.valueOf(200));
	}
	@PostMapping("/saveAll")
	public ResponseEntity<List<Admin>> saveAll(@RequestBody List<Admin> admins){
		return new ResponseEntity<List<Admin>>(adminService.saveAll(admins), HttpStatusCode.valueOf(201));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Admin> deleteById(@PathVariable("id") int id){
		return new ResponseEntity<Admin>(adminService.deleteById(id),HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Admin> updateFullBody(@PathVariable("id") int id,@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.updateFullObj(id,admin), HttpStatusCode.valueOf(200));
	}
}
