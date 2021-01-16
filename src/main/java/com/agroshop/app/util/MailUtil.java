package com.agroshop.app.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.agroshop.app.controller.rest.DriverController;
@Service
public class MailUtil {
	
	@Autowired
	private  JavaMailSender javaMailSender;
    private static final Logger logger = LogManager.getLogger(MailUtil.class);

	public void sendEmail(String to, String body, String subject) {
		logger.info("EmailUtil.sendEmail()");

		SimpleMailMessage simpleEmailMessage = new SimpleMailMessage();
		simpleEmailMessage.setFrom("sistema.agroshop@gmail.com");
		simpleEmailMessage.setTo(to);
		simpleEmailMessage.setSubject(subject);
		simpleEmailMessage.setText(body);
		javaMailSender.send(simpleEmailMessage);
		logger.info("EmailUtil.finalSendEmail()");

		}

}
