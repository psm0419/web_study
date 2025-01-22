package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.controller.service.user.UserService;
import com.app.dto.user.User;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;

	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("/")
	public String root() {
		return "redirect:/main";
	}
	
	@GetMapping("/customer/signup")
	public String signup() {
		return "customer/signup";
	}
	
	@PostMapping("/customer/signup")
	public String signupAction(User user) {
		user.setUserType("CUS");
		int result = userService.saveUser(user);
		System.out.println("저장 됐으면 1 출력, 결과: " + result);
		
		if (result > 0) {
			return "redirect:/main";
		}else {
			return "customer/signup";
		}
	}
	
}
