package com.demo.advsearchfiql.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long employeeId;

	@Column(name="firstname")
	private String firstname;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="birthdate")
	private Date birthDate;
	
	@Column(name="contactno")
	private String contactNo;

	

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", birthDate=" + birthDate + ", contactNo=" + contactNo + ", department=[" + department.getDepartmentId()+","+department.getDepartmentName() + "]";
	}

		
	
	

}
