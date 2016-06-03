package com.dc3.managedbean.sys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import com.dc3.model.sys.Role;
import com.dc3.model.sys.User;
import com.dc3.service.sys.UserService;

@ManagedBean(name = "userMB")
@RequestScoped
public class UserMB extends GenericMB implements Serializable {

	
	private static final long serialVersionUID = -4409114072243999090L;
	
	private User user;
	private Iterable<User> userList;
	@ManagedProperty("#{userService}")
	private UserService userService;
	private List<SelectItem> listUser;
	private List<User> selectedRows;
	private List<SelectItem> roleList;
	
	
	
	@PostConstruct
	public void init(){
		userList = userService.findAll();
		user = new User();
	}
	
	public void doSave(){
		userService.save(user);
		addInfoMessage("Usuario salvo com sucesso!");
		init();
	}
	
	public void doDelete(){
		for(User b : selectedRows){
			userService.delete(b.getIdUser());
		}
		userList = userService.findAll();
	}
	
	public void onRowEdit(RowEditEvent event) {
		userService.save((User) event.getObject());
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

    

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Iterable<User> getUserList() {
		return userList;
	}

	public void setUserList(Iterable<User> userList) {
		this.userList = userList;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<SelectItem> getListUser() {
		return listUser;
	}

	public void setListUser(List<SelectItem> listUser) {
		this.listUser = listUser;
	}

	public List<User> getSelectedRows() {
		return selectedRows;
	}

	public void setSelectedRows(List<User> selectedRows) {
		this.selectedRows = selectedRows;
	}
	


}
