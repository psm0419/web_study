package com.app.controller.study.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoffeeController {
	
	@Autowired
	CupBean cupBean;
	@Autowired
	PlateBean plateBean;
	
	@GetMapping("/quiz/bean/fullOrder")
	public String fullOrder() {
		System.out.println("컵에 음료 : " + cupBean.coffeeBean.name);
		System.out.println("접시에 디저트 : " + plateBean.dessertBean.name);
		
		return "quiz/quiz08/coffee";
	}
	
	@GetMapping("/quiz/bean/orderCoffee")
	public String orderCoffee () {
		System.out.println("컵에 음료 : " + cupBean.coffeeBean.name);
		
		return "quiz/quiz08/coffee";
	}
	
	@GetMapping("/quiz/bean/orderDessert")
	public String orderDessert() {
		System.out.println("접시에 디저트 : " + plateBean.dessertBean.name);
		
		return "quiz/quiz08/coffee";
	}
}
