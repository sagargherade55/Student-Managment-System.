package com.jsp.studentmanagmentsystem.entity;

import org.hibernate.annotations.GenericGenerator;

import com.jsp.studentmanagmentsystem.customid.CustomId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(generator = "custom_id")
	@GenericGenerator(name = "custom_id", type = CustomId.class)
	private int id;
	private String name;
	private String college;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private long contact;
	private String branch;
	private String dob;
	@Column(nullable = false, unique = true)
	private String prn;
	public Student() {
	}
	public Student(int id, String name, String college, String email, long contact, String branch, String dob,
			String prn) {
		this.id = id;
		this.name = name;
		this.college = college;
		this.email = email;
		this.contact = contact;
		this.branch = branch;
		this.dob = dob;
		this.prn = prn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPrn() {
		return prn;
	}
	public void setPrn(String prn) {
		this.prn = prn;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + ", email=" + email + ", contact="
				+ contact + ", branch=" + branch + ", dob=" + dob + ", prn=" + prn + "]";
	}
	
	
	
}
