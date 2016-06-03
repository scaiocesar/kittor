package com.dc3.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.dc3.model.sys.User;

@Entity
@Table(name="sale_order")
public class SaleOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8432004728825167167L;
	@Id
    @GeneratedValue
    private Integer idOrder;
	@ManyToOne (fetch=FetchType.EAGER )
    @JoinColumn(name="fk_customer", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
	private Customer customer;
	@ManyToOne (fetch=FetchType.EAGER )
    @JoinColumn(name="fk_vendedor", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
	private User vendedor;	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	private String numeroBoleto;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAbertura;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFechamento;
	@Temporal(TemporalType.TIME)
	private Date dataVencimentoPagamento;
	private String obs;
	private String historico;
	@Enumerated(EnumType.STRING)
	private PaymentMode meioPagamento;
	private Double totalValue;
	private Double discount;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
	private Set<ProductOrder> productOrderSet;
	
	
	public enum OrderStatus {
	    NOVA, EM_ANDAMENTO, FATURADA, AGUARDANDO_PAGAMENTO, FINALIZADA, REJEITADA, CANCELADA;
	}

	public enum PaymentMode {
		AVISTA,BOLETO,CREDITO,DEBITO;
	}


	public Integer getIdOrder() {
		return idOrder;
	}


	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public User getVendedor() {
		return vendedor;
	}


	public void setVendedor(User vendedor) {
		this.vendedor = vendedor;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public String getNumeroBoleto() {
		return numeroBoleto;
	}


	public void setNumeroBoleto(String numeroBoleto) {
		this.numeroBoleto = numeroBoleto;
	}


	public Date getDataAbertura() {
		return dataAbertura;
	}


	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	public Date getDataFechamento() {
		return dataFechamento;
	}


	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}


	public Date getDataVencimentoPagamento() {
		return dataVencimentoPagamento;
	}


	public void setDataVencimentoPagamento(Date dataVencimentoPagamento) {
		this.dataVencimentoPagamento = dataVencimentoPagamento;
	}


	public String getObs() {
		return obs;
	}


	public void setObs(String obs) {
		this.obs = obs;
	}


	public String getHistorico() {
		return historico;
	}


	public void setHistorico(String historico) {
		this.historico = historico;
	}


	public PaymentMode getMeioPagamento() {
		return meioPagamento;
	}


	public void setMeioPagamento(PaymentMode meioPagamento) {
		this.meioPagamento = meioPagamento;
	}


	public Double getTotalValue() {
		return totalValue;
	}


	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}


	public Double getDiscount() {
		return discount;
	}


	public void setDiscount(Double discount) {
		this.discount = discount;
	}


	public Set<ProductOrder> getProductOrderSet() {
		return productOrderSet;
	}


	public void setProductOrderSet(Set<ProductOrder> productOrderSet) {
		this.productOrderSet = productOrderSet;
	}


	@Override
	public boolean equals(Object obj) {
		SaleOrder t = (SaleOrder) obj;
	        if (t.getIdOrder() != null && this.getIdOrder() != null) {
	            if (t.getIdOrder().compareTo(this.getIdOrder()) == 0) {
	                return true;
	            }
	        }
	        return false;
	}

}
