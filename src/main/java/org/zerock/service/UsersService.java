package org.zerock.service;

import org.zerock.domain.UsersVO;

public interface UsersService {
	
	public void insert(UsersVO vo);
	public int update(UsersVO vo);
	public UsersVO getOne(String id);
	public int countById(String id);
	public int delete(long uno);
	public int countUsers();
}
