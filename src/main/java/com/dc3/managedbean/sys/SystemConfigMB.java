package com.dc3.managedbean.sys;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.apache.commons.mail.EmailException;

import com.dc3.model.sys.SystemConfig;
import com.dc3.service.sys.SystemConfigService;

@ManagedBean(name = "systemConfigMB")
@RequestScoped
public class SystemConfigMB extends GenericMB implements Serializable {

	
	private static final long serialVersionUID = 5374322553224676834L;
	
	private SystemConfig systemConfig;
	@ManagedProperty("#{systemConfigService}")
	private SystemConfigService systemConfigService;
	private String emailTestTo;
	
	
	
	@PostConstruct
	public void init(){
		systemConfig = systemConfigService.findOne();
		if(systemConfig == null){
			systemConfig = new SystemConfig();
		}
	}
	
	public void doSave(){
		systemConfigService.save(systemConfig);
		addInfoMessage("Salvo com sucesso!");
		init();
	}

	public SystemConfig getSystemConfig() {
		return systemConfig;
	}

	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}

	public SystemConfigService getSystemConfigService() {
		return systemConfigService;
	}

	public void setSystemConfigService(SystemConfigService systemConfigService) {
		this.systemConfigService = systemConfigService;
	}
	
	public void testEmail(){
		try {
			systemConfigService.testEmail(emailTestTo);
			addInfoMessage("Email enviado com sucesso!");
		} catch (EmailException e) {
			e.printStackTrace();
			addErrorMessage("Falha ao enviar email:"+e);
		}
	}

	public String getEmailTestTo() {
		return emailTestTo;
	}

	public void setEmailTestTo(String emailTestTo) {
		this.emailTestTo = emailTestTo;
	}
	

	


}
