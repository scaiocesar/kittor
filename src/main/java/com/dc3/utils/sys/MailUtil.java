package com.dc3.utils.sys;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;


public abstract class MailUtil  {
	
	
    private static final  String EMAIL_FROM = "caio@dc3.com.br";
    private static final  String EMAIL_PASSWORD = "zckwub1029";
    private static final  String HOST_NAME = "smtp.zoho.com";
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);


	public static void sendMail(String to,String subject, String htmlMessage, String emailFrom,String emailLogin, String emailPassword, String hostname, Integer port) throws EmailException{
		
		HtmlEmail email = new HtmlEmail();
		email.setHostName(hostname);
		email.setSmtpPort(port);
		email.setAuthenticator(new DefaultAuthenticator(emailLogin, emailPassword));
		email.setSSLOnConnect(true);
		email.setFrom(emailFrom);
		email.setSubject(subject);
		email.addTo(to);
		email.setHtmlMsg(htmlMessage);
		email.send();
	}
	
	public static void sendMailAssync(final String to,final String subject,final  String htmlMessage,final String emailFrom,final String emailLogin, final String emailPassword, final String hostname, final Integer port){
		//Execução assincrona
    	executor.execute(new Runnable() {
            @Override
            public void run() {
            	try{
            		sendMail(to,subject, htmlMessage, emailFrom, emailLogin, emailPassword,  hostname,  port);
            	}catch(EmailException e){
            		System.out.println(e);
            	}
            }
        }); 
	}

}
