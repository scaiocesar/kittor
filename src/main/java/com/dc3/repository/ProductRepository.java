package com.dc3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dc3.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	 
		String sqlFind = "select * from product "
				+ " where (codigoInterno ilike %:searchField% "
				+ " OR codigoEAN ilike %:searchField% "
				+ " OR nomeProduto ilike %:searchField% ) and ativo = true";

		String sqlUpdateAmount = "update product set amount = :amt where idproduct = :id";
				
		
		
		@Query(nativeQuery = true, value=sqlFind)
		List<Product> find(@Param("searchField") String searchField);

		@Modifying
		@Query(nativeQuery = true, value=sqlUpdateAmount)
		int updateAmount(@Param("amt") Integer amt,@Param("id") Integer id);
}
