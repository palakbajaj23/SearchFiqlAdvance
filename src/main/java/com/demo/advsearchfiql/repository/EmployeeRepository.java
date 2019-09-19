package com.demo.advsearchfiql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.advsearchfiql.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, CxfRepository<Employee, Long>{

}
