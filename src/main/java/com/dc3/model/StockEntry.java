package com.dc3.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table
public class StockEntry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4985185460748506608L;
	@Id
    @GeneratedValue
    private Integer idStock;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private Integer amount;
	@Enumerated(EnumType.STRING)
	private EntryType entryType;
	private String description;
	@ManyToOne (fetch=FetchType.EAGER )
    @JoinColumn(name="fk_product", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
	private Product product;
	
	public enum EntryType{
		ENTRADA, SAIDA;
	}
	
	
	public Integer getIdStock() {
		return idStock;
	}


	public void setIdStock(Integer idStock) {
		this.idStock = idStock;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}




	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

	public EntryType getEntryType() {
		return entryType;
	}
	
	
	public void setEntryType(EntryType entryType) {
		this.entryType = entryType;
	}

	@Override
	public boolean equals(Object obj) {
		StockEntry t = (StockEntry) obj;
	        if (t.getIdStock() != null && this.getIdStock() != null) {
	            if (t.getIdStock().compareTo(this.getIdStock()) == 0) {
	                return true;
	            }
	        }
	        return false;
	}



	
	
	
}
