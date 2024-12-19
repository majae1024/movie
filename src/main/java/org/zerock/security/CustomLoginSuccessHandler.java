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
//Authentication객체로 로그인한 사람의 정보 사용자의 이름, 권한, 인증된 시간 등을 알 수 있다.
@Log4j	
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
		
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{
		
		log.warn("------------------------Login Success--------------------");
		List<String> roleNames = new ArrayList<String>();//roleNames는 권한을 담기위한 배열 admin권한을 가진 사람은 role-admin과 role-mamber를 가지고 있기 때문에
		

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
