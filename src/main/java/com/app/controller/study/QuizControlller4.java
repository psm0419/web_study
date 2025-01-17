package com.app.controller.study;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuizControlller4 {

	@GetMapping("/quiz/session/login")
	public String login() {
		
		return"quiz/quiz07/login";
	}
	@PostMapping("/quiz/session/login")
	public String loginAction(HttpServletRequest request, HttpSession session) {
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		//위에 HttpSession 안쓰면 HttpSession session = request.getSession(); 선언
		
		session.setAttribute("id", request.getParameter("id"));
		session.setAttribute("pw", request.getParameter("pw"));
		session.setAttribute("count", 0);
		
		return"redirect:/quiz/session/count";
	}
	
	@GetMapping("/quiz/session/count")
	public String count(Model model, HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if (session.getAttribute("id") != null) {
	        count++;	       
	        session.setAttribute("count", count);
	    } else {
	    	model.addAttribute("count", 0);
	    }
		//모델로 안 옮겨도 가능
		model.addAttribute("id", session.getAttribute("id"));
//		model.addAttribute("count", count != null ? count : 0);
		
		return"quiz/quiz07/count";
	}
	
	@GetMapping("/quiz/session/logout")
	public String logout(HttpSession session) {
//		session.removeAttribute("id");
//		session.removeAttribute("count");
		session.invalidate();
		
		return"redirect:/quiz/session/count";
	}
}
