package com.app.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender sender;

	public boolean sendEmail(String to,String subject,
		//	String cc[],String bcc[],
			String text,CommonsMultipartFile file) {
		
		boolean flag=false;
		try {
			//1.Create Mime message object
			MimeMessage message = sender.createMimeMessage();
			//2.Take help of helper class object
			MimeMessageHelper helper = new MimeMessageHelper(message, file!=null?true:false);
			helper.setTo(to);
			helper.setFrom("sivakumarboga.teche@gmail.com");
			helper.setSubject(subject);
			helper.setText(text);
			//helper.setCc(cc);
		//	helper.setBcc(bcc);
			if(file!=null) 
				helper.addAttachment(file.getName(), file);
			else 
				System.out.println("File not found");
			sender.send(message);
			flag=true;
		}
		catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
	public boolean sendEmail(String to,String subject,String text) {
		return sendEmail(to, subject, text, null);
	}
	public boolean sendEmail(String to,String text) {
		return sendEmail(to, "NO SUBJECT", text, null);
	}
}
