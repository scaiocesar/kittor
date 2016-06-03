package com.dc3.service;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc3.model.ProductOrder;
import com.dc3.model.SaleOrder;
import com.dc3.model.SaleOrder.OrderStatus;
import com.dc3.model.StockEntry;
import com.dc3.model.StockEntry.EntryType;
import com.dc3.repository.OrderRepository;
import com.dc3.repository.ProductRepository;
import com.dc3.repository.StockEntryRepository;

@Service("orderService")
@Transactional
public class OrderService implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4904050198048656220L;
	/**
	 * 
	 */
	@Autowired
    private OrderRepository repo;
	@Autowired
	private StockEntryRepository stockRepo;
	@Autowired
	private ProductRepository productRepository;

    public Iterable<SaleOrder> listActiveOrder(){
    	return repo.listActiveOrder();
    }
    
    public Iterable<SaleOrder> findByStatus(OrderStatus status){
    	return repo.findByStatus(status);
    }
    
    public Iterable<SaleOrder> findAll(){
    	return repo.findAll();
    }

    public void doNewOrder(SaleOrder obj){
    	repo.save(obj);
    	Set<ProductOrder> producOrderSet = obj.getProductOrderSet();
    	for (ProductOrder productOrder : producOrderSet) {
    		StockEntry se = new StockEntry();
    		se.setEntryType(EntryType.SAIDA);
    		se.setAmount(productOrder.getAmount());
    		se.setDate(Calendar.getInstance().getTime());
			se.setDescription("Saida da venda: "+obj.getIdOrder()+"");
			se.setProduct(productOrder.getProduct());
			stockRepo.save(se);
			int newAmount = productOrder.getProduct().getAmount() - productOrder.getAmount();  
			productRepository.updateAmount(newAmount, productOrder.getProduct().getIdProduct());
		}
    }
    public void doReject(SaleOrder obj){
    	repo.save(obj);
    	Set<ProductOrder> producOrderSet = obj.getProductOrderSet();
    	for (ProductOrder productOrder : producOrderSet) {
    		StockEntry se = new StockEntry();
    		se.setEntryType(EntryType.ENTRADA);
    		se.setAmount(productOrder.getAmount());
    		se.setDate(Calendar.getInstance().getTime());
    		se.setDescription("Entrada da venda cancelada: "+obj.getIdOrder()+"");
    		se.setProduct(productOrder.getProduct());
    		stockRepo.save(se);
    		int newAmount = productOrder.getProduct().getAmount() + productOrder.getAmount();  
    		productRepository.updateAmount(newAmount, productOrder.getProduct().getIdProduct());
    	}
    }

    
    public void save(SaleOrder obj){
    	repo.save(obj);
    }

    public void delete(Integer id){
    	repo.delete(id);
    }
}
