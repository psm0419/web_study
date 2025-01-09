package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@GetMapping("/member/signup")
	public String signup() {
		System.out.println("member/signup 경로로 요청 들어옴");
		return "member/signup";
	}
}
