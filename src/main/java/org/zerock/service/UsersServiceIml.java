package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.UsersVO;
import org.zerock.mapper.UsersMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class UsersServiceIml implements UsersService{

	@Autowired 
	private UsersMapper mapper;
	
	@Override
	public void insert(UsersVO vo) {
		mapper.insert(vo);
		log.info(vo + "----입력 완료-----");
	}
	@Override
	public int update(UsersVO vo) {
		
		log.info(vo + "----수정완료----");

		return mapper.update(vo);
	};
	@Override
	public UsersVO getOne(String id) {
		// TODO Auto-generated method stub
		return mapper.getOne(id);
	}
	@Override
	public int countById(String id) {
		// TODO Auto-generated method stub
		return mapper.countById(id);
	}
	@Override
	public int delete(long uno) {
		// TODO Auto-generated method stub
		return mapper.delete(uno);
	}
	@Override
	public int countUsers() {
		// TODO Auto-generated method stub
		return mapper.countUsers();
	};
	
}
