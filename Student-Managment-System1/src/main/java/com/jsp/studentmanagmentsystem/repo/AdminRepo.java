package com.jsp.studentmanagmentsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.studentmanagmentsystem.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
