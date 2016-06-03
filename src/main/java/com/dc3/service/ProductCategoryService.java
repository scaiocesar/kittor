package com.dc3.service;


import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc3.model.ProductCategory;
import com.dc3.repository.ProductCategoryRepository;

@Service("productCategoryService")
@Transactional
public class ProductCategoryService implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4124626675225241910L;
	/**
	 * 
	 */
	@Autowired
    private ProductCategoryRepository repo;
	

    public Iterable<ProductCategory> findAll(){
    	return repo.findAll();
    }
    
    public void save(ProductCategory obj){
    	repo.save(obj);
    }

    public void delete(Integer id){
    	repo.delete(id);
    }
}
