package com.app.controller.study.quiz09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Quiz09Controller {
	@Autowired
	CustomerService customerService;
	RoomService roomService;

	public Quiz09Controller(CustomerService customerService, RoomService roomService) {
		this.customerService = customerService;
		this.roomService = roomService;
	}

	// 등록 페이지
	@GetMapping("/quiz/customer")
	public String customer() {
		System.out.println("customer get요청");
		return "quiz/quiz09/quiz09";
	}
	@GetMapping("/quiz/room")
	public String room() {
		System.out.println("room get요청");
		return "quiz/quiz09/quiz09";
	}

	// 고객 등록 요청
	@PostMapping("/quiz/customer")
	public String registerCustomer(@RequestParam String name, @RequestParam int age, @RequestParam String phone) {
		CustomerDTO customerDTO = new CustomerDTO(name, age, phone);
		
		//매개변수로 받은 객체 전달 -> 서비스
		int result = customerService.registerCustomer(customerDTO);
		if(result >0) { //저장 성공
			System.out.println("고객 등록 완료");
			return "quiz/quiz09/quiz09";
		}else { //저장 실패
			System.out.println("고객 등록 실패");
			return "quiz/quiz09/quiz09";
		}
	}

	// 객실 등록 요청
	@PostMapping("/quiz/room")
	public String registerRoom(RoomDTO roomDTO) {		
		int result = roomService.registerRoom(roomDTO);
		
		if(result >0) {
			System.out.println("객실 등록 완료");
			return "quiz/quiz09/quiz09";
		}else { //저장 실패
			System.out.println("객실 등록 실패");
			return "quiz/quiz09/quiz09";
		}
	}
}
