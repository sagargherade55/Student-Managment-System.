package com.jsp.studentmanagmentsystem.service;

import java.util.List;
import java.util.Optional;

import com.jsp.studentmanagmentsystem.entity.Admin;

public interface AdminService {

	public Admin save(Admin admin);
	public List<Admin> saveAll(List<Admin> admins);
	public List<Admin> viewAll();
	public Admin deleteById(int id);
	public Optional<Admin> getByID(int id);
	public Admin updateFullObj(int id, Admin admin);
}
