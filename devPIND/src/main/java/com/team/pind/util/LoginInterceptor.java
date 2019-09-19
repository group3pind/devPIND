package com.team.pind.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//세션의 로그인 정보 읽어오기 
		HttpSession session = request.getSession();
		String logId = (String) session.getAttribute("logId");
		
		//로그인 상태가 아닐 경우 로그인 페이지로 이동
		if ( logId == null ) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		
		return true;
	}
}//end::Class
