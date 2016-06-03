package com.dc3.managedbean.sys;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;

import com.dc3.model.sys.User;

public class GenericMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1653639109550491653L;
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return 	 (User) getHttpServletRequest().getSession().getAttribute("user");
		
	}
	
	protected HttpServletRequest getHttpServletRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}


	public void addErrorMessage(String msg) {
		msg = StringEscapeUtils.escapeHtml(msg);
		FacesMessage fm = new FacesMessage(msg);
		fm.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage("msgs", fm);
	}

	public void addInfoMessage(String msg) {
		msg = StringEscapeUtils.escapeHtml(msg);
		FacesMessage fm = new FacesMessage(msg);
		fm.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("msgs", fm); 
	}

	public void addWarnMessage(String msg) {
		msg = StringEscapeUtils.escapeHtml(msg);
		FacesMessage fm = new FacesMessage(msg);
		fm.setSeverity(FacesMessage.SEVERITY_WARN);
		FacesContext.getCurrentInstance().addMessage("msgs", fm); 
	}
	
}
