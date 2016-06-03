package com.dc3.service;


import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc3.model.Product;
import com.dc3.model.ProductOrder;
import com.dc3.model.StockEntry;
import com.dc3.model.StockEntry.EntryType;
import com.dc3.repository.ProductRepository;
import com.dc3.repository.StockEntryRepository;

@Service("productService")
@Transactional
public class ProductService implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7975410489757933189L;
	@Autowired
    private ProductRepository repo;
	@Autowired
	private StockEntryRepository stockEntryRepo;
	
	public List<StockEntry> getStock(Product p){
		return stockEntryRepo.findByProductOrderByDateDesc(p);
	}

    public Iterable<Product> findAll(){
    	return repo.findAll();
    }

    public Iterable<Product> find(String str){
    	return repo.find(str);
    }
    
    @Transactional
    public void save(Product obj){
    	Integer id = obj.getIdProduct();
    	repo.save(obj);
    	if(id > 0){
		StockEntry se = new StockEntry();
		se.setEntryType(EntryType.ENTRADA);
		se.setAmount(obj.getAmount());
		se.setDate(Calendar.getInstance().getTime());
		se.setProduct(obj);
			se.setDescription("Cadastro inicial: "+obj.getAmount()+"");
			stockEntryRepo.save(se);
		}
    }

    public void delete(Integer id){
    	repo.delete(id);
    }
}
