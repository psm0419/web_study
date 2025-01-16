package com.app.controller.study;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.study.Request1;

@Controller
public class QuizController2 {

	@GetMapping("/request1-1")
	public String request11(HttpServletRequest request) {
		
		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("product"));
		
		request.setAttribute("category", request.getParameter("category"));
		request.setAttribute("product", request.getParameter("product"));
		
		return "quiz/quiz05/request1";
	}
	
	@RequestMapping("/request1-2")
	public String request12(@RequestParam String category, @RequestParam String product, Model model) {
				 
		System.out.println(category);
		System.out.println(product);
		
		model.addAttribute("category", category);
        model.addAttribute("product", product);
        
		return "quiz/quiz05/request1";
	}
	
	@RequestMapping("/request1-3")
	public String request13(@ModelAttribute Request1 request1) {
		//@ModelAttribute 생략해도 자동으로 적용해줌
		System.out.println(request1.getCategory());
		System.out.println(request1.product);
		
		//set~ 안해도 자동으로 할당함. getter setter는 만들어 놔야함

		return "quiz/quiz05/request1";
	}
	
	@RequestMapping("/request1-4")
	public String request14(@RequestParam Map<String, String> paramMap, Model model) {
		
		System.out.println(paramMap.get("category"));			
		System.out.println(paramMap.get("product"));	
		
		model.addAttribute("category", paramMap.get("category"));
	    model.addAttribute("product", paramMap.get("product"));

		return "quiz/quiz05/request1";
	}
}
