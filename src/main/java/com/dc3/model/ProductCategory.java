package com.dc3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class ProductCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5154218037085336900L;
	/**
	 * 
	 */
	@Id
    @GeneratedValue
    private Integer idProductsCategory;
	private String categoria;
	
	public Integer getIdProductsCategory() {
		return idProductsCategory;
	}
	public void setIdProductsCategory(Integer idProductsCategory) {
		this.idProductsCategory = idProductsCategory;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public boolean equals(Object obj) {
		ProductCategory t = (ProductCategory) obj;
	        if (t.getIdProductsCategory() != null && this.getIdProductsCategory() != null) {
	            if (t.getIdProductsCategory().compareTo(this.getIdProductsCategory()) == 0) {
	                return true;
	            }
	        }
	        return false;
	}
	
	
	
}
