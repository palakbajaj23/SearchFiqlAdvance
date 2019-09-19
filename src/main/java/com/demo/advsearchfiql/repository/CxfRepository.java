package com.demo.advsearchfiql.repository;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.cxf.jaxrs.ext.search.SearchContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CxfRepository<T, ID> extends JpaRepository<T, ID> {

	List<T> customSearch(SearchContext context);

	List<Tuple> customSearch(SearchContext context, List<SingularAttribute<T, ?>> selections);

	<E> List<E> customSearch(SearchContext context, List<SingularAttribute<T, ?>> selections, Class<E> clz);
}
