package com.au.local.amazon;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public static void main(String args[]) {
		String from="rajasekar.puniyamoorthy@gmail.com";
		String to="umarajasekar.er@gmail.com";
		String password="Adolfhitler1@";
		Properties properties=System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");    
		properties.put("mail.smtp.socketFactory.port", "465");    
		properties.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
		properties.put("mail.smtp.auth", "true");    
		properties.put("mail.smtp.port", "465");
		
		//get Session   
        Session session = Session.getDefaultInstance(properties,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);  
         }    
        });
        
        MimeMessage message = new MimeMessage(session);    
        try {
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setSubject("Test Email");    
			message.setText("This email is sent for test purpose");    
	        //send message  
	        Transport.send(message);    
	        System.out.println("message sent successfully"); 
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
          
	}

}
