package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.app.controller.service.user.UserService;


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
	
	
}
