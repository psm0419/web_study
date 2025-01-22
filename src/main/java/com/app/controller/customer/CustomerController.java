package com.app.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.common.CommonCode;
import com.app.controller.service.user.UserService;
import com.app.dto.user.User;
import com.app.util.LoginManager;


@Controller
public class CustomerController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/customer")
    public String customer() {
        return "quiz/quiz09/quiz09";
    }
	
	@PostMapping("/customer")
    public String customerAction() {
        return "quiz/quiz09/quiz09";
    }

	@GetMapping("/customer/signup")
	public String signup() {
		return "customer/signup";
	}
	
	@PostMapping("/customer/signup")
	public String signupAction(User user) {
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		int result = userService.saveUser(user);
		System.out.println("저장 됐으면 1 출력, 결과: " + result);
		
		if (result > 0) {
			return "redirect:/main";
		}else {
			return "customer/signup";
		}
	}
	
	@GetMapping("/customer/login")
	public String login() {
		return "customer/login";
	}
	
	@PostMapping("/customer/login")
	public String loginAction(User user, HttpSession session) {
		//user 로그인 할 수 있게 정보가 들어있는지 확인
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		User loginUser = userService.checkUserLogin(user);
		
		if (loginUser == null) {
			return "customer/login";
		}else {
//			session.setAttribute("loginUser", loginUser);
//			session.setAttribute("loginUserId", loginUser.getId());
			LoginManager.setSessionLogin(session, loginUser.getId());
			
			return "redirect:/main";
		}
	}
	
	@GetMapping("/customer/logout")
	public String logout(HttpSession session) {
		LoginManager.logout(session);
//		session.invalidate();
		return "redirect:/main";
	}
	
	@GetMapping("/customer/mypage")
	public String mypage(HttpSession session, Model model) {
		//session에 id값이 없으면 로그인 페이지로 보낸다
//		if(session.getAttribute("loginUserId") != null) {
		if(LoginManager.isLogin(session)) {			
		
//			User user = userService.findUserById((String)session.getAttribute("loginUserId"));
			User user = userService.findUserById( LoginManager.getLoginUserId(session));
			model.addAttribute("user", user);
			
			return "customer/mypage";
		}
		return "redirect:/customer/login";
	}
}
