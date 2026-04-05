package com.jsp.studentmanagmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsp.studentmanagmentsystem.entity.Admin;
import com.jsp.studentmanagmentsystem.exception.ResoueseNotFoundException;
import com.jsp.studentmanagmentsystem.repo.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepo adminRepo;

	@Override
	public Admin save(Admin admin) {
		return adminRepo.save(admin);
	}

	@Override
	public List<Admin> viewAll() {
		return adminRepo.findAll();
	}

	@Override
	public List<Admin> saveAll(List<Admin> admins) {
		return adminRepo.saveAll(admins);
	}

	@Override
	public Admin deleteById(int id) {
		Optional<Admin> optional = getByID(id);
		
		if (optional.isEmpty()) throw new ResoueseNotFoundException("Object not present in DB");
		Admin admin = optional.get();
		adminRepo.delete(admin);
		return admin;
		
	}

	@Override
	public Optional<Admin> getByID(int id) {
		return adminRepo.findById(id);
	}

	@Override
	public Admin updateFullObj(int id,Admin admin) {
		Optional<Admin> optional = getByID(id);
		if(optional.isEmpty()) throw new ResoueseNotFoundException("Object is not present in DB");
		
		Admin admin2 = optional.get();
		admin2.setEmail(admin.getEmail());
		admin2.setPassword(admin.getPassword());
		return adminRepo.save(admin2);
	}

}
