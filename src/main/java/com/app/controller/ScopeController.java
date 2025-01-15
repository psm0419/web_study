package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.Member;

@Controller
public class ScopeController {

	@GetMapping("/scope1")
	public String scope1(Model model) {

		model.addAttribute("requestMsg", "request scope 메시지");

		return "scope/scope1";
	}

	@GetMapping("/scope2")
	public String scope2(HttpServletRequest request) {

		request.setAttribute("requestMsg", "request scope 메시지");

		HttpSession session = request.getSession();
		session.setAttribute("sessionMsg", "session scope 메시지");

		ServletContext app = request.getServletContext();
		app.setAttribute("applicationMsg", "application scope 메시지");
//		app.removeAttribute("applicationMsg");
//		어플리케이션은 사용 잘 안함
		return "scope/scope2";
	}

	@GetMapping("/scope3")
	public String scope3() {

		return "scope/scope3";
	}

	@GetMapping("/scope4")
	public String scope4(HttpSession session) {
		// 추가, 수정(같은이름이면 수정)
		session.setAttribute("sessionMsg", "scope4 session scope 메시지");
		// 삭제(개별적, 같은이름만)
		session.removeAttribute("sessionMsg");
		// session 영역에 저장된 모든 속성 제거 (세션초기화)
		session.invalidate();

		return "scope/scope3";
	}

	@GetMapping("/scopeCheck/{accessUrl}")
	public String scopeCheck(@PathVariable String accessUrl, Model model, HttpSession session) {
	    if (accessUrl.equals("firsthide2")) {
	    	session.setAttribute("accessUrl", accessUrl);
	        return "redirect:/scopeCheck/first";
	    } else {
	        model.addAttribute("accessUrl", accessUrl);
	        return "/scopeCheck/targetPage";
	    }
	}

	@GetMapping("/scopeCheck/first")
	public String scopeCheckFirst(Model model, HttpSession session) {
		if(session.getAttribute("accessUrl") == null) {
			//request > session 출력우선순위
			model.addAttribute("accessUrl", "/first");
		} else {
			System.out.println(session.getAttribute("accessUrl"));
			model.addAttribute("accessUrl", session.getAttribute("accessUrl"));		
			session.removeAttribute("accessUrl");
		}
		
		return "/scopeCheck/targetPage";

	}
}
