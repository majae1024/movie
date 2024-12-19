package org.zerock.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	 @Autowired
	    private JavaMailSender mailSender;

	 
	    public EmailService(JavaMailSender mailSender) {
	        this.mailSender = mailSender;
	    }
	 
	    public void sendEmail(String to, String subject, String body) {
	    	 try {
	             // MimeMessage ����
	             MimeMessage message = mailSender.createMimeMessage();
	             
	             // Helper�� ����
	             MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
	             helper.setTo(to);
	             helper.setSubject(subject);
	             
	             // HTML �������� �̸��� ���� ����
	             helper.setText(body, true);  // �� ��° �Ű������� `true`�� �����ϸ� HTML�� ó����
	             
	             // �̸��� ����
	             mailSender.send(message);
	         } catch (Exception e) {
	             throw new RuntimeException("�̸��� ���� �� ���� �߻�", e);
	         }
	    }
}
