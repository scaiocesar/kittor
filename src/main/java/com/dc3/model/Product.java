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
@Table
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4985185460748506608L;
	@Id
    @GeneratedValue
    private Integer idProduct;
	private String codigoInterno;
	private String codigoEAN;
	private String codigoNCM;
	private String nomeProduto;
	@ManyToOne (fetch=FetchType.EAGER )
    @JoinColumn(name="fk_categoria", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
	private ProductCategory categoria;
	private String dimensao;
	private Double precoCusto;
	private Double precoAtacado;
	private Double precoVarejo;
	private Integer amount;
	private String urlImagem1;
	private String urlImagem2;
	private String urlImagem3;
	private Boolean ativo;
	
	
	public String toString(){
		return codigoInterno+" - "+nomeProduto;
	}
	
	public String getCodigoInterno() {
		return codigoInterno;
	}
	public void setCodigoInterno(String codigoInterno) {
		this.codigoInterno = codigoInterno;
	}
	public String getCodigoEAN() {
		return codigoEAN;
	}
	public void setCodigoEAN(String codigoEAN) {
		this.codigoEAN = codigoEAN;
	}
	public String getCodigoNCM() {
		return codigoNCM;
	}
	public void setCodigoNCM(String codigoNCM) {
		this.codigoNCM = codigoNCM;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public ProductCategory getCategoria() {
		return categoria;
	}
	public void setCategoria(ProductCategory categoria) {
		this.categoria = categoria;
	}
	public String getDimensao() {
		return dimensao;
	}
	public void setDimensao(String dimensao) {
		this.dimensao = dimensao;
	}
	public Double getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}
	public String getUrlImagem1() {
		return urlImagem1;
	}
	public void setUrlImagem1(String urlImagem1) {
		this.urlImagem1 = urlImagem1;
	}
	public String getUrlImagem2() {
		return urlImagem2;
	}
	public void setUrlImagem2(String urlImagem2) {
		this.urlImagem2 = urlImagem2;
	}
	public String getUrlImagem3() {
		return urlImagem3;
	}
	public void setUrlImagem3(String urlImagem3) {
		this.urlImagem3 = urlImagem3;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Double getPrecoAtacado() {
		return precoAtacado;
	}
	public void setPrecoAtacado(Double precoAtacado) {
		this.precoAtacado = precoAtacado;
	}
	public Double getPrecoVarejo() {
		return precoVarejo;
	}
	public void setPrecoVarejo(Double precoVarejo) {
		this.precoVarejo = precoVarejo;
	}
	
	@Override
	public boolean equals(Object obj) {
		Product t = (Product) obj;
	        if (t.getIdProduct() != null && this.getIdProduct() != null) {
	            if (t.getIdProduct().compareTo(this.getIdProduct()) == 0) {
	                return true;
	            }
	        }
	        return false;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	
}
