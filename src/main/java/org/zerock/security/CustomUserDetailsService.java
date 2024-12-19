package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.UsersVO;
import org.zerock.mapper.UsersMapper;
import org.zerock.security.domain.CustomUser;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersMapper usersMapper;  // ȸ�������� ��������

	@Override
            //loadUserByUsername �޼��带 ���� ����� �̸��� �Է�, �Է¹��� �̸����� DB���� ����� ������ ��ȸ
            //��ȸ�� ����� ������ Spring Security�� UserDetails ��ü�� ��ȯ�Ͽ� ��ȯ
	public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
		log.warn("Load User By Username : " + user_id);
		// ����� �̸����� �����ͺ��̽����� ȸ�� ������ ��ȸ
				UsersVO vo = usersMapper.getOne(user_id);
			
				log.warn("queried by user mapper: " + vo);
		                       // ��ȸ�� UsersVO�� ������� CustomUser ��ü�� �����Ͽ� ��ȯ (��ȸ ����� ���� ��� null ��ȯ)
				return vo == null ? null : new CustomUser(vo);
	} 

}