package com.app.controller.study;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.study.DrinkItem;

@RestController
public class ReactAPIController {

	@GetMapping("/api/getMsg")
	public String apiGetMsg() {

		System.out.println("/api/getMsg");

		return "welcome~";
	}

	@GetMapping("/api/getDrinks")
	public List<DrinkItem> getDrinks() {

		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		drinkList.add(new DrinkItem("아메리카노", "커피"));
		drinkList.add(new DrinkItem("카페라떼", "커피"));
		drinkList.add(new DrinkItem("콜라", "탄산음료"));

		// service -> DAO -> DB

		return drinkList;
	}

	@GetMapping("/api/getDrinksDiv")
	public List<DrinkItem> getDrinksDiv(HttpServletRequest request) {
		String type = request.getParameter("type");
		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		if (type != null) {
			if (type.equals("커피")) {
				drinkList.add(new DrinkItem("아메리카노", "커피"));
				drinkList.add(new DrinkItem("카페라떼", "커피"));
			}
			if (type.equals("탄산음료")) {
				drinkList.add(new DrinkItem("콜라", "탄산음료"));
				drinkList.add(new DrinkItem("사이다", "탄산음료"));
				drinkList.add(new DrinkItem("웰치스", "탄산음료"));
			}
			
			System.out.println(type);
		}

		return drinkList;
	}
	
	@PostMapping("/api/getDrinksDrinkItem")
	public List<DrinkItem> getDrinksDrinkItem(@RequestBody DrinkItem drinkItem){
		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		System.out.println(drinkItem.getItem());
		System.out.println(drinkItem.getType());
		return drinkList;
	}
	
	@PostMapping("/api/getDrinksNum")
	public List<DrinkItem> getDrinksNum(@RequestBody String num){
		System.out.println(num);
		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();		
		
		drinkList.add(new DrinkItem("item"+num, "type"+num));
		
		
		return drinkList;
	}
}
