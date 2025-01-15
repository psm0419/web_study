package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dto.Member;

@Controller
public class RedirectController {

	@GetMapping("/re/re1")
	public String re1() {

		return "re/re1";
	}
	
	@GetMapping("/re/re2")
	public String re2(HttpServletRequest request) {
		System.out.println(request.getParameter("msg"));
		return "re/re2";
	}
	
	@GetMapping("/re/re3")
	public String re3(HttpServletRequest request) {

		System.out.println(request.getParameter("msg"));
//		return "re/re2";
		return "re/re3";
	}
	
	@GetMapping("/re/re4")
	public String re4(HttpServletRequest request, RedirectAttributes ra) {
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", "re4 redirect msg"); // redirect시 안넘어감
		ra.addAttribute("msg", "re4 ra msg"); //파라미터 넘기기
		
//		return "re/re2"; -> view경로 re2.jsp(파일위치)
//		return "redirect:/re/re2"; //내가 요청 할 주소(파일위치X)
//		return "redirect:/re/re2?msg=re4 redirect msg"; //경로에 파라미터 추가
		return "redirect:/re/re2";
	}
	
	@GetMapping("/re/re5")
	public String re5(HttpServletRequest request) {
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", "re5 forward msg");
		
//		리퀘스트도 같이 넘어가서 2번 출력 됨
		return "forward:/re/re2"; //내가 요청 할 주소(파일위치X)
	}
	
	@GetMapping("/re/listTest")
	public String listTest(@RequestParam String type) {
		if(type.equals("str")) {
			return "redirect:/jstl/listTest/str";
		}
		return "forward:/jstl/listTest/member";
	}
	
	
}
