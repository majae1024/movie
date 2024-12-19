package org.zerock.mapper;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.UsersVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class AdminMapperTests {

	@Autowired
	private AdminMapper mapper;

	@Test
	public void testgetSearchUsersWithPaging() {
		Criteria cri = new Criteria();
		cri.setKeyword("admin");
		cri.setType("IN");
		
		List<UsersVO> result = mapper.getSearchUsersWithPaging(cri);
		result.forEach(user -> log.info(user));
	}

//	@Test
//	public void testSearch() {
//		Map<String, String> map = new HashMap<String, String>();
//
//		map.put("I", "admin");
//		map.put("N", "Å×½ºÆ®");
//
//		Map<String, Map<String, String>> outer = new HashMap<>();
//		outer.put("map", map);
//
//		List<UsersVO> list = mapper.searchTest(outer);
//		log.info(list);
//
//	}
	
	@Test
	public void testGetUserInfoByUno() {
		UsersVO result = mapper.getUserInfoByUno(12);
		log.info(result);
	}

}
