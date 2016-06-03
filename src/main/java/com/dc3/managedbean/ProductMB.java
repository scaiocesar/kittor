package com.dc3.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.dc3.managedbean.sys.GenericMB;
import com.dc3.model.Product;
import com.dc3.model.ProductCategory;
import com.dc3.model.StockEntry;
import com.dc3.service.ProductCategoryService;
import com.dc3.service.ProductService;

@ManagedBean(name = "productMB")
@RequestScoped
public class ProductMB extends GenericMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4691736494340016641L;
	private Product obj;
	private Product selectedObj;
	private Iterable<Product> list;
	@ManagedProperty("#{productService}")
	private ProductService service;
	@ManagedProperty("#{productCategoryService}")
	private ProductCategoryService serviceCategory;
	private Iterable<ProductCategory> listCategory;
	private List<StockEntry> listStock;
	
	private Boolean openPanel;

	@PostConstruct
	public void init() {
		obj = new Product();
		list = service.findAll();
		openPanel = false;
		
		//Popula Combo
		listCategory = serviceCategory.findAll();
		
		
	}
	
	public void listStock(){
		listStock = service.getStock(obj);
	}

	public void doSave() {
		service.save(obj);
		addInfoMessage("Produto salvo com sucesso!");
		init();
	}

	public void doDelete() {
			service.delete(selectedObj.getIdProduct());
		list = service.findAll();
	}

	public void doUpdate() {
		obj = selectedObj;
		listStock();
		openPanel = true;
	}

	public void onRowEdit(RowEditEvent event) {
		service.save((Product) event.getObject());
		addInfoMessage("Cadastro Alterado!");
		
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edição Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Product getObj() {
		return obj;
	}

	public void setObj(Product obj) {
		this.obj = obj;
	}

	public Iterable<Product> getList() {
		return list;
	}

	public void setList(Iterable<Product> list) {
		this.list = list;
	}

	public ProductService getService() {
		return service;
	}

	public void setService(ProductService service) {
		this.service = service;
	}


	public ProductCategoryService getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(ProductCategoryService serviceCategory) {
		this.serviceCategory = serviceCategory;
	}


	public Boolean getOpenPanel() {
		return openPanel;
	}

	public void setOpenPanel(Boolean openPanel) {
		this.openPanel = openPanel;
	}

	public Iterable<ProductCategory> getListCategory() {
		return listCategory;
	}

	public void setListCategory(Iterable<ProductCategory> listCategory) {
		this.listCategory = listCategory;
	}

	public Product getSelectedObj() {
		return selectedObj;
	}

	public void setSelectedObj(Product selectedObj) {
		this.selectedObj = selectedObj;
	}

	public List<StockEntry> getListStock() {
		return listStock;
	}

	public void setListStock(List<StockEntry> listStock) {
		this.listStock = listStock;
	}

}
