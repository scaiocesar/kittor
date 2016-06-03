package com.dc3.model.sys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Realiza a configuração do sistema
 * @author Bozo
 *
 */
@Entity
public class SystemConfig implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3344308580821285214L;
	@Id
    @GeneratedValue
    private int idSystemConfig;
    @Column(length=5000)
	private String htmlEmailConfirmationLayout;
    private String emailConfirmationSubject;
    private String emailFrom;
    private String emailLogin;
    private String emailPassword;
    private String hostname;
    private Integer port;
    
    
	public int getIdSystemConfig() {
		return idSystemConfig;
	}
	public void setIdSystemConfig(int idSystemConfig) {
		this.idSystemConfig = idSystemConfig;
	}
	public String getHtmlEmailConfirmationLayout() {
		return htmlEmailConfirmationLayout;
	}
	public void setHtmlEmailConfirmationLayout(String htmlEmailConfirmationLayout) {
		this.htmlEmailConfirmationLayout = htmlEmailConfirmationLayout;
	}
	public String getEmailConfirmationSubject() {
		return emailConfirmationSubject;
	}
	public void setEmailConfirmationSubject(String emailConfirmationSubject) {
		this.emailConfirmationSubject = emailConfirmationSubject;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	public String getEmailPassword() {
		return emailPassword;
	}
	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getEmailLogin() {
		return emailLogin;
	}
	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}
   
	
}

