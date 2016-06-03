package com.dc3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dc3.model.Product;
import com.dc3.model.StockEntry;

public interface StockEntryRepository extends CrudRepository<StockEntry, Integer> {
	 
	List<StockEntry> findByProductOrderByDateDesc(Product product);
	
}
