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
	             // MimeMessage 생성
	             MimeMessage message = mailSender.createMimeMessage();
	             
	             // Helper로 설정
	             MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
	             helper.setTo(to);
	             helper.setSubject(subject);
	             
	             // HTML 포맷으로 이메일 내용 설정
	             helper.setText(body, true);  // 두 번째 매개변수에 `true`를 설정하면 HTML로 처리됨
	             
	             // 이메일 전송
	             mailSender.send(message);
	         } catch (Exception e) {
	             throw new RuntimeException("이메일 전송 중 오류 발생", e);
	         }
	    }
}
