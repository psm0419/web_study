package com.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.app.common.CommonCode;
import com.app.controller.service.user.UserService;
import com.app.dto.user.User;
import com.app.util.LoginManager;

public class AdminInterceptor implements HandlerInterceptor{

	@Autowired UserService userService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(LoginManager.isLogin(request) == false) { //로그인 안되어 있다
			response.sendRedirect("/error/error");
			//경고창("잘못된 접근입니다"); -> main 연결
			return false;
		}
		if(LoginManager.isLogin(request)) {
			
			String userId = LoginManager.getLoginUserId(request);
			
			User loginUser = userService.findUserById(userId);
			if(loginUser.getUserType().equals(CommonCode.USER_USERTYPE_ADMIN) == false) {
				response.sendRedirect("/error/error");
				//경고창("잘못된 접근입니다"); -> main 연결
				return false;
			}
			
			return false; //더이상 진행하지 않게 막음
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
