package org.zerock.mapper;


import org.zerock.domain.UsersVO;


public interface UsersMapper {
	
	
	public void insert(UsersVO vo);
	
	public UsersVO getOne(String id);
	
	public int update(UsersVO vo);
	
	public int delete(long uno);

	public int countById(String id);
	
	public String getRole(long uno);
	
	public int countUsers();
}
