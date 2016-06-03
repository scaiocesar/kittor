package com.dc3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table()
public class ProductOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2954534332175318029L;
	@Id
    @GeneratedValue
    private Integer idProductOrder;
	@ManyToOne (fetch=FetchType.EAGER )
    @JoinColumn(name="fk_product", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
	private Product product;
	@ManyToOne (fetch=FetchType.EAGER )
    @JoinColumn(name="fk_saleOrder", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
	private SaleOrder saleOrder;
	private Integer amount;
	private Double precoUnitario;
	private Double precoTotal;
	private String obs;
	
	public Integer getIdProductOrder() {
		return idProductOrder;
	}
	public void setIdProductOrder(Integer idProductOrder) {
		this.idProductOrder = idProductOrder;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public Double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public SaleOrder getSaleOrder() {
		return saleOrder;
	}
	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}
	
	@Override
	public boolean equals(Object obj) {
		ProductOrder t = (ProductOrder) obj;
	        if (t.getIdProductOrder() != null && this.getIdProductOrder() != null) {
	            if (t.getIdProductOrder().compareTo(this.getIdProductOrder()) == 0) {
	                return true;
	            }
	        }
	        return false;
	}

	
}
