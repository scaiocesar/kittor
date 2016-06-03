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

import com.dc3.model.sys.User;

@Entity
@Table
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6204580154629375165L;
	@Id
    @GeneratedValue
    private Integer idCustomer;
	private String razaoSocial;
	private String nomeFantasia;
	private String cpfCnpj;
	private Boolean isCpf =false;
	@ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="fk_systemUser", insertable=true, updatable=true)
    @Fetch(FetchMode.SELECT)
	private User systemUser;
	private String telefone1;
	private String telefone2;
	private String email;
	private String uf;
	private String cidade;
	private String bairro;
	private String cep;
	private String logradouro;
	private String complemento;

	private Boolean ativo;
	private Double limiteCompra;
	
	
	
	public String toString(){
		return getRazaoSocial()+" - "+ getCpfCnpj();
	}
	
	public Integer getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public Boolean getIsCpf() {
		return isCpf;
	}
	public void setIsCpf(Boolean isCpf) {
		this.isCpf = isCpf;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Double getLimiteCompra() {
		return limiteCompra;
	}
	public void setLimiteCompra(Double limiteCompra) {
		this.limiteCompra = limiteCompra;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public User getSystemUser() {
		return systemUser;
	}
	public void setSystemUser(User systemUser) {
		this.systemUser = systemUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		Customer t = (Customer) obj;
	        if (t.getIdCustomer() != null && this.getIdCustomer() != null) {
	            if (t.getIdCustomer().compareTo(this.getIdCustomer()) == 0) {
	                return true;
	            }
	        }
	        return false;
	}
	
}
