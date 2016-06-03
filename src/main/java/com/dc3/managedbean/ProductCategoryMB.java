package com.dc3.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import com.dc3.managedbean.sys.GenericMB;
import com.dc3.model.ProductCategory;
import com.dc3.model.sys.Role;
import com.dc3.service.ProductCategoryService;

@ManagedBean(name = "productCategoryMB")
@RequestScoped
public class ProductCategoryMB extends GenericMB implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2856751832501990940L;
	private ProductCategory obj;
	private Iterable<ProductCategory> list;
	@ManagedProperty("#{productCategoryService}")
	private ProductCategoryService service;
	private List<ProductCategory> selectedRows;
	
	
	
	@PostConstruct
	public void init(){
		list = service.findAll();
		obj = new ProductCategory();
	}
	
	public void doSave(){
		service.save(obj);
		addInfoMessage("Salvo com sucesso!");
		init();
	}
	
	public void doDelete(){
		for(ProductCategory b : selectedRows){
			service.delete(b.getIdProductsCategory());
		}
		list = service.findAll();
	}
	
	public void onRowEdit(RowEditEvent event) {
		service.save((ProductCategory) event.getObject());
        addInfoMessage("Cadastro Alterado!");
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição Cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    public List<SelectItem> getRoleList() {

		List<SelectItem> items = new ArrayList<SelectItem>();

		for (Role role : Role.values()) {
			items.add(new SelectItem(role,role.toString()));
		}

		return items;
	}

	public ProductCategory getObj() {
		return obj;
	}

	public void setObj(ProductCategory obj) {
		this.obj = obj;
	}

	public Iterable<ProductCategory> getList() {
		return list;
	}

	public void setList(Iterable<ProductCategory> list) {
		this.list = list;
	}

	public ProductCategoryService getService() {
		return service;
	}

	public void setService(ProductCategoryService service) {
		this.service = service;
	}

	public List<ProductCategory> getSelectedRows() {
		return selectedRows;
	}

	public void setSelectedRows(List<ProductCategory> selectedRows) {
		this.selectedRows = selectedRows;
	}

	


}
