package com.demo.advsearchfiql.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, String> firstname;
	public static volatile SingularAttribute<Employee, Long> employeeId;
	public static volatile SingularAttribute<Employee, Department> department;
	public static volatile SingularAttribute<Employee, Date> birthDate;
	public static volatile SingularAttribute<Employee, String> lastname;
	public static volatile SingularAttribute<Employee, String> contactNo;

	public static final String FIRSTNAME = "firstname";
	public static final String EMPLOYEE_ID = "employeeId";
	public static final String DEPARTMENT = "department";
	public static final String BIRTH_DATE = "birthDate";
	public static final String LASTNAME = "lastname";
	public static final String CONTACT_NO = "contactNo";

}

