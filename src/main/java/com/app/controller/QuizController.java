package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuizController {

	
	@GetMapping("/quiz/req1")
	public String req1 () {
		System.out.println("/quiz/req1 GET 요청");
		return "quiz/req1";
	}
	@PostMapping("/quiz/req1")
	public String req1Post () {
		System.out.println("/quiz/req1 POST 요청");
		return "quiz/req1";
	}
	
	@RequestMapping("/quiz/req2")
	public String req2(HttpServletRequest request) {
		
		System.out.println(request.getParameter("data1"));
		System.out.println(request.getParameter("data2"));
		
		System.out.println("/quiz/req2 요청");
		
		request.setAttribute("data1", request.getParameter("data1"));
		request.setAttribute("data2", request.getParameter("data2"));
		
		return "quiz/req2";
	}
	
	@GetMapping("/quiz03/pathA")
	public String pathA () {
		System.out.println("/quiz03/pathA GET 요청");
		return "quiz03/pathA";
	}
	
	@GetMapping("/quiz03/pathB")
	public String pathB () {
		System.out.println("/quiz03/pathB GET 요청");
		return "quiz03/pathB";
	}
	
	@RequestMapping("/quiz03/pathCommon/A")
	public String pathCommonA () {
		System.out.println("/quiz03/pathCommon/A Request 요청");
		return "quiz03/pathA";
	}
	
	@RequestMapping("/quiz03/pathCommon/B")
	public String pathCommonB () {
		System.out.println("/quiz03/pathCommon/B Request 요청");
		return "quiz03/pathB";
	}
	
	@RequestMapping("/quiz03/pathCommon/{pathName}")
	public String pathCommonB (@PathVariable String pathName, Model model) {
		model.addAttribute("productName", pathName);
		return "quiz03/pathB";
	}
}
