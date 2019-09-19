package com.demo.advsearchfiql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import com.demo.advsearchfiql.repository.CxfRepositoryImpl;

@SpringBootApplication
@ComponentScan(basePackages= {"com.demo.advsearchfiql"})
@EnableJpaRepositories(basePackages= {"com.demo.advsearchfiql.repository"},repositoryBaseClass = CxfRepositoryImpl.class)
public class SearchFiqlAdvanceApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(SearchFiqlAdvanceApplication.class, args);
	}

}
