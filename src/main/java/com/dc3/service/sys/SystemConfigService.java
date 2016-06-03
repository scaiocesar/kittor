package com.dc3.service.sys;

import java.io.Serializable;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc3.model.sys.SystemConfig;
import com.dc3.repository.sys.SystemConfigRepository;
import com.dc3.utils.sys.MailUtil;

@Service("systemConfigService")
@Transactional
public class SystemConfigService implements Serializable {

    @Autowired
    private SystemConfigRepository repository;

    
    public SystemConfig findOne(){
    	return repository.findSystemConfig();
    }
    
    public void save(SystemConfig obj){
    	repository.save(obj);
    }
    
    public void testEmail(String emailTo) throws EmailException{
    	SystemConfig sc = findOne();
			MailUtil.sendMail(
					emailTo, 
					"Teste de envio de email", 
					"O ENVIO DE EMAIL ESTA FUNCIONANDO o/",
					sc.getEmailFrom(),
					sc.getEmailLogin(),
					sc.getEmailPassword(),
					sc.getHostname(),
					sc.getPort()
					);
    }

}
