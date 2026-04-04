package com.jsp.studentmanagmentsystem.service;

import java.util.List;

import com.jsp.studentmanagmentsystem.entity.Admin;

public interface AdminService {

	public Admin save(Admin admin);
	public List<Admin> view();
}
