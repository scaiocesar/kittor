package com.dc3.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.dc3.managedbean.sys.GenericMB;
import com.dc3.model.Customer;
import com.dc3.service.CustomerService;

@ManagedBean(name = "customerMB")
@ViewScoped
public class CustomerMB extends GenericMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1877617786363563764L;
	/**
	 * 
	 */
	private Customer obj;
	private Iterable<Customer> list;
	@ManagedProperty("#{customerService}")
	private CustomerService service;
	private List<Customer> selectedRows;
	private Boolean openPanel;

	@PostConstruct
	public void init() {
		obj = new Customer();
		list = service.findAll();
		
	}
	
	public void changeCPF(){
		openPanel = true;
	}

	public void doSave() {
		service.save(obj);
		addInfoMessage("Salvo com sucesso!");
		init();
	}

	public void doDelete() {
		for (Customer b : selectedRows) {
			service.delete(b.getIdCustomer());
		}
		list = service.findAll();
	}

	public void doUpdate() {
		for (Customer b : selectedRows) {
			obj = b;
		}
		openPanel = true;
	}

	public void onRowEdit(RowEditEvent event) {
		service.save((Customer) event.getObject());
		addInfoMessage("Cadastro Alterado!");
		
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edição Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Customer getObj() {
		return obj;
	}

	public void setObj(Customer obj) {
		this.obj = obj;
	}

	public Iterable<Customer> getList() {
		return list;
	}

	public void setList(Iterable<Customer> list) {
		this.list = list;
	}

	public CustomerService getService() {
		return service;
	}

	public void setService(CustomerService service) {
		this.service = service;
	}

	public List<Customer> getSelectedRows() {
		return selectedRows;
	}

	public void setSelectedRows(List<Customer> selectedRows) {
		this.selectedRows = selectedRows;
	}

	public Boolean getOpenPanel() {
		return openPanel;
	}

	public void setOpenPanel(Boolean openPanel) {
		this.openPanel = openPanel;
	}

}
