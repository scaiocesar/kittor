package com.dc3.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import com.dc3.managedbean.sys.GenericMB;
import com.dc3.model.Customer;
import com.dc3.model.Product;
import com.dc3.model.ProductOrder;
import com.dc3.model.SaleOrder;
import com.dc3.model.SaleOrder.OrderStatus;
import com.dc3.service.CustomerService;
import com.dc3.service.OrderService;
import com.dc3.service.ProductService;

@ManagedBean(name = "newOrderMB")
@ViewScoped
public class NewOrderMB extends GenericMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4691736494340016641L;
	private SaleOrder order;
	private Iterable<SaleOrder> listOrders;

	private ProductOrder productOrder;
	private Set<ProductOrder> listProductOrder;
	private List<ProductOrder> selectedRows;

	
	@ManagedProperty("#{orderService}")
	private OrderService orderService;

	@ManagedProperty("#{customerService}")
	private CustomerService customerService;
	private Customer customer;
	
	@ManagedProperty("#{productService}")
	private ProductService productService;
	private List<Product> listProducts;
	private Product product;
	
	


	@PostConstruct
	public void init() {
		order = new SaleOrder();
		order.setStatus(OrderStatus.NOVA);
		order.setDataAbertura(new Date());
		order.setVendedor(getUser());
		listProducts = new ArrayList<Product>();
		listProductOrder = new HashSet<ProductOrder>();
	}
	
	
	public void doSave(){
		order.setProductOrderSet(listProductOrder);
		order.setHistorico("");
		orderService.doNewOrder(order);
		addInfoMessage("Pedido "+order.getIdOrder()+" enviado!");
		init();
	}
	
	public void doList(){
		listOrders =  orderService.findByStatus(OrderStatus.NOVA);
	}
	
	public void addProductOrder(SelectEvent event){
		ProductOrder po = new ProductOrder();
		Product p = (Product)event.getObject();
		po.setSaleOrder(order);
		po.setAmount(1);
		if(customer.getIsCpf()){
			po.setPrecoUnitario(p.getPrecoVarejo());
		}else{
			po.setPrecoUnitario(p.getPrecoAtacado());
		}
		po.setPrecoTotal(po.getPrecoUnitario());
		po.setProduct(p);
		listProductOrder.add(po);
		product = null;
		updateTotalPrice();
	}
	
	private void updateTotalPrice(){
		Double totalPrice = 0d;
		for (ProductOrder po : listProductOrder) {
			totalPrice += po.getPrecoTotal();
		}
		order.setTotalValue(totalPrice);
	}
	
	public void selectCustomer(SelectEvent event){
		customer = (Customer) event.getObject();
	}
	
     
	public void onRowEdit(RowEditEvent event) {
		ProductOrder po = (ProductOrder) event.getObject();
		po.setPrecoTotal(po.getPrecoUnitario() * po.getAmount());
		updateTotalPrice();
    }
	
	public void removeProductOrder(){
		for(ProductOrder b : selectedRows){
			listProductOrder.remove(b);
		}
	}
	
	public Iterable<Customer> findCustomer(String query){
		Iterable<Customer> l = customerService.find(query); 
		return l;
	}
	
	public Iterable<Product> findProduct(String query){
		Iterable<Product> l = productService.find(query); 
		return l;
	}
	

	public SaleOrder getOrder() {
		return order;
	}


	public void setOrder(SaleOrder order) {
		this.order = order;
	}


	public ProductOrder getProductOrder() {
		return productOrder;
	}


	public void setProductOrder(ProductOrder productOrder) {
		this.productOrder = productOrder;
	}




	public OrderService getOrderService() {
		return orderService;
	}


	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}


	public CustomerService getCustomerService() {
		return customerService;
	}


	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	public ProductService getProductService() {
		return productService;
	}


	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<ProductOrder> getSelectedRows() {
		return selectedRows;
	}

	public void setSelectedRows(List<ProductOrder> selectedRows) {
		this.selectedRows = selectedRows;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<ProductOrder> getListProductOrder() {
		return listProductOrder;
	}

	public void setListProductOrder(Set<ProductOrder> listProductOrder) {
		this.listProductOrder = listProductOrder;
	}

	public Iterable<SaleOrder> getListOrders() {
		return listOrders;
	}

	public void setListOrders(Iterable<SaleOrder> listOrders) {
		this.listOrders = listOrders;
	}





}
