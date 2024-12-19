package org.zerock.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class EmailReviewServiceTest {
	 @Autowired
	    private EmailService emailService;
	 @Test
	    public void testSendEmail() {
	        emailService.sendEmail("asd102432@gmail.com", "테스트 제목", "테스트 메시지");
	    }

}
