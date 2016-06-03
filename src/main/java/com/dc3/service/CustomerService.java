package com.dc3.service;


import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc3.model.Customer;
import com.dc3.repository.CustomerRepository;

@Service("customerService")
@Transactional
public class CustomerService implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7975410489757933189L;
	@Autowired
    private CustomerRepository repo;
	

    public Iterable<Customer> findAll(){
    	return repo.findAllOrderBy();
    }


    public Iterable<Customer> find(String str){
    	return repo.find(str);
    }
    
    
    public void save(Customer obj){
    	repo.save(obj);
    }

    public void delete(Integer id){
    	repo.delete(id);
    }
}
