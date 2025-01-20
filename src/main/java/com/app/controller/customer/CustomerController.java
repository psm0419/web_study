package com.app.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.controller.service.user.UserService;


@Controller
public class CustomerController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/customer32")
    public String customer() {
        return "quiz/quiz09/quiz09";
    }
	
	@PostMapping("/customer234")
    public String customerAction() {
        return "quiz/quiz09/quiz09";
    }

}
