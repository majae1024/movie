package org.zerock.security.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.zerock.domain.UsersVO;

import lombok.Getter;

@Getter
public class CustomUser extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	private UsersVO user;

	public CustomUser(String user_id, String user_pw, Collection<? extends GrantedAuthority> authorities) {

		super(user_id, user_pw, authorities);
	}

	// UsersVO ��ü�� �޴� ������
	 public CustomUser(UsersVO vo) {
	        // UsersVO���� ���� role ���� SimpleGrantedAuthority�� ��ȯ
	        super(vo.getUser_id(), vo.getUser_pw(), 
	              Collections.singletonList(new SimpleGrantedAuthority(vo.getRole())));
	        this.user = vo; // UsersVO ��ü�� ����
	    }
}
