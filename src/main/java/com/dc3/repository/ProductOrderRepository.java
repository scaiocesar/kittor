package com.dc3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dc3.model.SaleOrder;
import com.dc3.model.ProductOrder;

public interface ProductOrderRepository extends CrudRepository<ProductOrder, Integer> {
	
	List<ProductOrder> findBySaleOrder(SaleOrder o);
	
}
