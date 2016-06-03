package com.dc3.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.dc3.managedbean.sys.GenericMB;
import com.dc3.model.ProductOrder;
import com.dc3.model.SaleOrder;
import com.dc3.model.SaleOrder.OrderStatus;
import com.dc3.service.OrderService;
/**
 * Gerencia os estagios do Pedido (SaleOrder)
 * @author Caio
 *
 */
@ManagedBean(name = "approveOrderQueueMB")
@ViewScoped
public class ApproveOrderQueueMB extends GenericMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4691736494340016641L;
	private SaleOrder order;
	private SaleOrder selectedOrder;
	@ManagedProperty("#{orderService}")
	private OrderService orderService;
	private Iterable<SaleOrder> listOrders;
	
	private Iterable<ProductOrder> listProductOrder;
	private Boolean openPanel;
	private String historico;


	@PostConstruct
	public void init() {
		selectedOrder = new SaleOrder();
		order = new SaleOrder();
		openPanel = false;
		historico = "";
		doListNewOrder();
	}
	
	public void doPreview(){
		openPanel = true;
	}
	
	public void doOnGoing(){
		order.setStatus(OrderStatus.EM_ANDAMENTO);
		order.setHistorico(order.getHistorico()+historico+"\n");
		orderService.save(order);
		addInfoMessage("Pedido "+order.getIdOrder()+" em andamento");
		init();
	}

	public void doEnvoiced(){
		order.setStatus(OrderStatus.FATURADA);
		order.setHistorico(order.getHistorico()+historico+"\n");
		orderService.save(order);
		addInfoMessage("Pedido "+order.getIdOrder()+" faturado");
		init();
	}

	public void doFinish(){
		order.setStatus(OrderStatus.FINALIZADA);
		order.setHistorico(order.getHistorico()+historico+"\n");
		orderService.save(order);
		addInfoMessage("Pedido "+order.getIdOrder()+" finalizado");
		init();
	}
	public void doReject(){
		order.setStatus(OrderStatus.REJEITADA);
		order.setHistorico(order.getHistorico()+historico+"\n");
		orderService.doReject(order);
		addErrorMessage("Pedido "+order.getIdOrder()+" rejeitado");
		init();
		
	}
	public void doCancel(){
		order.setStatus(OrderStatus.CANCELADA);
		order.setHistorico(order.getHistorico()+historico+"\n");
		orderService.doReject(order);
		addErrorMessage("Pedido "+order.getIdOrder()+" Cancelado");
		init();
		
	}
	
	public void doListNewOrder(){
		listOrders =  orderService.findByStatus(OrderStatus.NOVA);
	}
	
	public void doSave(){
		addInfoMessage("Pedido "+order.getIdOrder()+" enviado!");
	}

	public SaleOrder getOrder() {
		return order;
	}

	public void setOrder(SaleOrder order) {
		this.order = order;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public Iterable<SaleOrder> getListOrders() {
		return listOrders;
	}

	public void setListOrders(Iterable<SaleOrder> listOrders) {
		this.listOrders = listOrders;
	}

	public Iterable<ProductOrder> getListProductOrder() {
		return listProductOrder;
	}

	public void setListProductOrder(Iterable<ProductOrder> listProductOrder) {
		this.listProductOrder = listProductOrder;
	}

	public SaleOrder getSelectedOrder() {
		return selectedOrder;
	}

	public void setSelectedOrder(SaleOrder selectedOrder) {
		this.selectedOrder = selectedOrder;
	}

	public Boolean getOpenPanel() {
		return openPanel;
	}

	public void setOpenPanel(Boolean openPanel) {
		this.openPanel = openPanel;
	}

	public String getObs() {
		return historico;
	}

	public void setObs(String obs) {
		this.historico = obs;
	}

	
	
}
