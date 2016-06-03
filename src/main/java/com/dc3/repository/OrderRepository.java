package com.dc3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dc3.model.SaleOrder;
import com.dc3.model.SaleOrder.OrderStatus;

public interface OrderRepository extends CrudRepository<SaleOrder, Integer> {
	
	@Query(value="select * from sale_order  where status not in ('CANCELADA','FINALIZAD') order by dataAbertura ASC", nativeQuery = true)
	List<SaleOrder> listActiveOrder();
	
	List<SaleOrder> findByStatus(OrderStatus status);
	
}
