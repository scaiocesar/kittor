package com.dc3.model.sys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dc3.model.SaleOrder;

@Entity
@Table(name = "system_user")
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3521490484331836302L;

	@Id
    @GeneratedValue
    private Integer idUser;
    private String email;
    private String name;
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    private Boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Role role;


    public User(){
    }

    public User(Integer idUser){
    	this.idUser = idUser;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	@Override
	public boolean equals(Object obj) {
		User t = (User) obj;
	        if (t.getIdUser() != null && this.getIdUser() != null) {
	            if (t.getIdUser().compareTo(this.getIdUser()) == 0) {
	                return true;
	            }
	        }
	        return false;
	}
	
}