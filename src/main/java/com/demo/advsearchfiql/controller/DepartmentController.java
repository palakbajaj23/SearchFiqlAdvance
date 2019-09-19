package com.demo.advsearchfiql.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.ext.search.PropertyNotFoundException;
import org.apache.cxf.jaxrs.ext.search.SearchContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.advsearchfiql.entity.Department;
import com.demo.advsearchfiql.repository.DepartmentRepository;

@Path("/search")
public class DepartmentController {

	private static final Logger LOG = LogManager.getLogger(Department.class);

	@Context
	private SearchContext context;

	@Autowired
	private DepartmentRepository departmentRepository;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GET
	@Path("/dept")
	
	public String searchDept() {
		List<Department> deptList = new ArrayList<Department>();
		try {
			deptList = departmentRepository.customSearch(context);
		} catch (PropertyNotFoundException e) {
			LOG.error("Property Not found:::" + e.getName());
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return "hello";
	}

}
