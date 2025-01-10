package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {

	@GetMapping("/quiz/main")
	public String main() {
		
		return "quiz/main";
	}
	
	@GetMapping("/quiz/product/mouse")
	public String mouse() {
		
		return "quiz/product/mouse";
	}
	
	@GetMapping("/quiz//product/keyboard")
	public String keyboard() {
		
		return "quiz//product/keyboard";
	}
}
