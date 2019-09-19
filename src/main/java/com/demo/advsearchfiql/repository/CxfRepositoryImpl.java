package com.demo.advsearchfiql.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchConditionVisitor;
import org.apache.cxf.jaxrs.ext.search.SearchContext;
import org.apache.cxf.jaxrs.ext.search.jpa.JPACriteriaQueryVisitor;
import org.apache.cxf.jaxrs.ext.search.jpa.JPATypedQueryVisitor;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.demo.advsearchfiql.entity.Employee;
import com.demo.advsearchfiql.model.EmployeeInfo;

public class CxfRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CxfRepository<T, ID> {

	private EntityManager entityManager;

	public CxfRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public List<T> customSearch(SearchContext context) {
		SearchCondition<T> sc = context.getCondition(getDomainClass());
		SearchConditionVisitor<T, TypedQuery<T>> visitor = new JPATypedQueryVisitor(this.entityManager,
				getDomainClass());
		sc.accept(visitor);
		TypedQuery<T> typedQuery = visitor.getQuery();
		return typedQuery.getResultList();
	}

	@Override
	public List<Tuple> customSearch(SearchContext context, List<SingularAttribute<T, ?>> selections) {
		SearchCondition<T> sc = context.getCondition(getDomainClass());
		JPACriteriaQueryVisitor<T, Tuple> visitor = new JPACriteriaQueryVisitor<T, Tuple>(this.entityManager,
				getDomainClass(), Tuple.class);
		sc.accept(visitor);
		visitor.selectTuple(selections);
		CriteriaQuery<Tuple> criteria = visitor.getQuery();
		TypedQuery<Tuple> query = this.entityManager.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public <E> List<E> customSearch(SearchContext context, List<SingularAttribute<T, ?>> selections, Class<E> clz) {
		SearchCondition<T> sc = context.getCondition(getDomainClass());
		JPACriteriaQueryVisitor<T, E> visitor = new JPACriteriaQueryVisitor<T, E>(entityManager, getDomainClass(), clz);
		sc.accept(visitor);
		visitor.selectConstruct(selections);
		CriteriaQuery<E> criteria = visitor.getQuery();
		TypedQuery<E> query = entityManager.createQuery(criteria);
		return query.getResultList();

	}

}
