package com.demo.advsearchfiql.model;

public class EmployeeInfo {

	private Long employeeId;
	private String firstname;

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

	public EmployeeInfo(Long employeeId, String firstname) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
	}

	@Override
	public String toString() {
		return "EmployeeInfo [employeeId=" + employeeId + ", firstname=" + firstname + "]";
	}

}
