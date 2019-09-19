package com.demo.advsearchfiql.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.SingularAttribute;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.apache.cxf.jaxrs.ext.search.PropertyNotFoundException;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchContext;
import org.apache.cxf.jaxrs.ext.search.jpa.JPACriteriaQueryVisitor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.advsearchfiql.entity.Employee;
import com.demo.advsearchfiql.entity.Employee_;
import com.demo.advsearchfiql.model.EmployeeInfo;
import com.demo.advsearchfiql.repository.EmployeeRepository;

@Path("/search")
public class EmployeeController {

	@Context
	private SearchContext context;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private EmployeeRepository empRepo;

	private static final Logger LOG = LogManager.getLogger(Employee.class);

	/* Using tuple for selecting some columns */
	@GET
	@Path("/emp1")
	public String searchResultTrial1() {
		try {
			List<SingularAttribute<Employee, ?>> selections = new LinkedList<SingularAttribute<Employee, ?>>();
			selections.add(Employee_.employeeId);
			selections.add(Employee_.firstname);
			List<Tuple> list = empRepo.customSearch(context, selections);

			for (Tuple tuple : list) {
				Long id = tuple.get("employeeId", Long.class);
				String firstname = tuple.get("firstname", String.class);
				System.out.println("ID::" + id + ", firstname::" + firstname);
			}

		} catch (PropertyNotFoundException e) {
			LOG.error("Property Not found:::" + e.getName());
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		return "Hello";
	}

	/* Get object in user defined bean */
	@GET
	@Path("/emp2")
	public String searchResultTrial2() {
		List<EmployeeInfo> list = new ArrayList<>();
		try {
			List<SingularAttribute<Employee, ?>> selections = new LinkedList<SingularAttribute<Employee, ?>>();
			selections.add(Employee_.employeeId);
			selections.add(Employee_.firstname);
			list = empRepo.customSearch(context, selections,EmployeeInfo.class);
			for (EmployeeInfo info : list) {
				System.out.println("info::" + info);
			}
		} catch (PropertyNotFoundException e) {
			LOG.error("Property Not found:::" + e.getName());
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		return "hello";
	}

}
