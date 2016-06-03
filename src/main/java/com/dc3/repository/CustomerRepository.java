package com.dc3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dc3.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	 
	String sqlFind = "select * from customer "
			+ " where (razaosocial ilike %:searchField% "
			+ " OR nomeFantasia ilike %:searchField% "
			+ " OR email ilike %:searchField% "
			+ " OR cpfCnpj ilike %:searchField% )"
			+ " AND ativo = true ";
	
	
	@Query("select c from Customer c order by c.razaoSocial asc")
	List<Customer> findAllOrderBy();


	@Query(nativeQuery = true, value=sqlFind)
	List<Customer> find(@Param("searchField") String searchField);
	
}
