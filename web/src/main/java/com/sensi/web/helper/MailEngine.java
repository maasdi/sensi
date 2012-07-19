package com.sensi.web.helper;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 * Jul 19, 2012
 */
public class MailEngine {
	
	private MailSender mailSender;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMessage(SimpleMailMessage message){
		mailSender.send(message);
	}

}
