package com.dc3.repository;

import org.springframework.data.repository.CrudRepository;

import com.dc3.model.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
}
