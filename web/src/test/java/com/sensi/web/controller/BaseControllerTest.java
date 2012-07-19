package com.sensi.web.controller;

import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 * Jul 19, 2012
 */

@ContextConfiguration(
        locations = {"classpath*:com/sensi/**/applicationContext.xml",
                "classpath*:com/sensi/**/security.xml"})
public class BaseControllerTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Test
	public void canSendEmailTest() {
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) applicationContext.getBean("mailSender");
		mailSender.setPort(587);
		mailSender.setHost("smtp.gmail.com");
		mailSender.setUsername("maas.dianto@gmail.com");
		mailSender.setPassword("password");
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("maas.dianto@gmail.com");
		message.setTo("maas.dianto@gmail.com");
		message.setSubject("test");
		message.setText("test from sensi");
		
		mailSender.send(message);
	}

}
