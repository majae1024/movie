package org.zerock.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.UsersVO;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class UsersMapperTests {
	
	@Autowired
	private UsersMapper mapper;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Test
	public void testInsert() {
		UsersVO vo = new UsersVO();
		for(var i=100; i<=102; i++ ) {
		vo.setUser_id("test" + i);
		vo.setUser_name("익명" + i);
		vo.setUser_pw("1234");
		vo.setBirth("----");
		mapper.insert(vo);
		log.info(vo);}
	}

	
	@Test
	public void testupdate() {
		UsersVO users = new UsersVO();
		users.setUno((long) 67);
		users.setUser_name("익명100");
		users.setUser_pw(encoder.encode("1234"));
		users.setBirth("----");
		int result = mapper.update(users);
		log.info("update " + result);
		}	
	
	/*
	@Test 
	public void testCountUserId() {
	int result = mapper.countById("test11");
	log.info(result);
	}*/
	/*
	@Test
	public void testDeleteByUsers() {
		for(var i =1; i<=50; i++) {
		int result = mapper.delete(i);
		log.info(result);}
	}*/
	/*
	@Test
	public void testGetOne() {
		UsersVO result = mapper.getOne("admin");
		log.info(result);
	}*//*
	@Test
	public void testGetRole() {
		String result = mapper.getRole(21);
		log.info(result);
	}*/
	/*
	@Test
	public void testCountusers() {
		int result = mapper.countUsers();
		log.info(result);
	}*/
}
