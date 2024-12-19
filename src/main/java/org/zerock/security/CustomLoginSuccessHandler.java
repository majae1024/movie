package org.zerock.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;
//Authentication��ü�� �α����� ����� ���� ������� �̸�, ����, ������ �ð� ���� �� �� �ִ�.
@Log4j	
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
		
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{
		
		log.warn("------------------------Login Success--------------------");
		List<String> roleNames = new ArrayList<String>();//roleNames�� ������ ������� �迭 admin������ ���� ����� role-admin�� role-mamber�� ������ �ֱ� ������
		

		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
		
		log.warn("ROLE NAMES =------------------------->>>>" +roleNames+"<<<<---------------------------------");
		
		if(roleNames.contains("role_1")) {
			response.sendRedirect("admin/adminDashboard");
			return;
		}
		if(roleNames.contains("role_0")) {
			response.sendRedirect("/movie/index");
			return;
		}
		

		
	}
}
