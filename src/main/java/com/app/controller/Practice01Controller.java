package com.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.Request;

@Controller
public class Practice01Controller {

	@RequestMapping("/prac01/request1-1")
	public String request1(HttpServletRequest request) {
		System.out.println("request");
		System.out.println(request.getParameter("item"));
		System.out.println(request.getParameter("type"));

		return "prac01/request1";
	}

	@RequestMapping("/prac01/request1-2")
	public String request2(@RequestParam String item, @RequestParam String type) {
		System.out.println("@RequestParam");
		System.out.println(item);
		System.out.println(type);

		return "prac01/request1";
	}

	@RequestMapping("/prac01/request1-3")
	public String request3(@RequestParam Map<String, String> paramMap) {
		System.out.println("@RequestParam Map");
		System.out.println(paramMap.get("item"));
		System.out.println(paramMap.get("type"));

		return "prac01/request1";
	}

	@RequestMapping("/prac01/request1-4")
	public String request4(@ModelAttribute Request request) {
		System.out.println("@ModelAttribute");
		System.out.println(request.getItem());
		System.out.println(request.getType());

		return "prac01/request1";
	}

	@RequestMapping("/prac01/viewData1-1")
	public String viewData1(HttpServletRequest request) {
		System.out.println("request");
		System.out.println(request.getParameter("item"));
		System.out.println(request.getParameter("type"));

		request.setAttribute("item", request.getParameter("item"));
		request.setAttribute("type", request.getParameter("type"));

		return "prac01/viewData1";
	}

	@RequestMapping("/prac01/viewData1-2")
	public String viewData2(@RequestParam String item, 
            @RequestParam String type, Model model) {
		System.out.println("model");
		System.out.println(item);
	    System.out.println(type);
		
		model.addAttribute("item", item);
	    model.addAttribute("type", type);
		
		return "prac01/viewData1";
	}
	
	@RequestMapping("/prac01/viewData1-3")
	public ModelAndView viewData3(@RequestParam String item, 
            @RequestParam String type, ModelAndView mav) {
		System.out.println("ModelAndView");
		System.out.println(item);
	    System.out.println(type);
		
		mav.setViewName("prac01/viewData1");
		mav.addObject("item", item);
		mav.addObject("type", type);	
		
		return mav;
	}
	
	@RequestMapping("/prac01/viewData1-4")
	public String viewData4(@RequestParam String item, 
            @RequestParam String type, Model model) {
		System.out.println("model 객체");
		System.out.println(item);
	    System.out.println(type);
		
		Request request = new Request();
		request.setItem(item);
		request.setType(type);
		
		
		model.addAttribute("request", request);
		
		return "prac01/viewData1";
	}
}
