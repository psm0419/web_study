package com.app.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.ApiCommonCode;
import com.app.common.CommonCode;
import com.app.controller.service.user.UserService;
import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.user.User;
import com.app.dto.user.UserDupCheck;
import com.app.dto.user.UserValidError;
import com.app.util.LoginManager;
import com.app.validator.UserCutomValidator;

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
	public String signupAction(/*@Valid*/ @ModelAttribute User user, BindingResult br, Model model) {
		//별도로 생성한 UserVaildError 객체 사용하는 케이스
		UserValidError userValidError = new UserValidError();
		boolean validResult =  UserCutomValidator.validate(user, userValidError);
		
		if(validResult == false) { //오류 발생
			//유효성 검증 통과 실패
			//저장 진행하지 않고 다시 가입페이지로 이동
			model.addAttribute("userValidError", userValidError);
			return "customer/signup";
		}
		
		
		/* bindingresult 사용하는 케이스
		//유효성 검증
		UserCutomValidator.validate(user, br);
		
		//유효성 검증 성공 여부
		
		if (br.hasErrors()) { // 제약조건에 걸린 에러가 있다
			List<ObjectError> errorList = br.getAllErrors();
			for (ObjectError er : errorList) {
				System.out.println(er.getObjectName());
				System.out.println(er.getDefaultMessage());
				System.out.println(er.getCode());
				System.out.println(er.getCodes());
			}
			return "customer/signup";			
		}
		*/

		// 검증 먼저 하고 저장
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		int result = userService.saveUser(user);
		System.out.println("저장 됐으면 1 출력, 결과: " + result);
		
		if (result > 0) {
			return "redirect:/main";
		} else {
			return "customer/signup";
		}
	}
	
//	@InitBinder("user")
//	public void initUserBinder(WebDataBinder binder) {
//		UserValidator validator = new UserValidator();
//		binder.addValidators(validator);
//	}	
	
	

	@GetMapping("/customer/login")
	public String login() {
		return "customer/login";
	}

	@PostMapping("/customer/login")
	public String loginAction(User user, HttpSession session) {
		// user 로그인 할 수 있게 정보가 들어있는지 확인
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		User loginUser = userService.checkUserLogin(user);

		if (loginUser == null) {
			return "customer/login";
		} else {
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
		// session에 id값이 없으면 로그인 페이지로 보낸다
//		if(session.getAttribute("loginUserId") != null) {
		if (LoginManager.isLogin(session)) {

//			User user = userService.findUserById((String)session.getAttribute("loginUserId"));
			User user = userService.findUserById(LoginManager.getLoginUserId(session));
			model.addAttribute("user", user);

			return "customer/mypage";
		}
		return "redirect:/customer/login";
	}

	@ResponseBody
	@RequestMapping("/customer/checkDupId")
	public String checkDupId(@RequestBody String data) {
		System.out.println("checkDupId 요청 들어옴");
		System.out.println(data);
		// 매개변수 data : 중복여부를 확인하고 싶은 아이디
		// DB에 아이디 있는지 확인
		boolean result = userService.isDuplicatedId(data);

		if (result == true) {
			return "Y";
		} else {
			return "N";
		}
	}

	@ResponseBody
	@RequestMapping("/customer/checkDupIdJson")
	public ApiResponse<String> checkDupIdJson(@RequestBody UserDupCheck userDupCheck) {
		// JSON format Text -> UserDupCheck 객체로 파싱
		System.out.println("checkDupIdJson 요청 들어옴");
		System.out.println(userDupCheck);

		// DB에 아이디 있는지 확인
		boolean result = userService.isDuplicatedId(userDupCheck.getId());

		ApiResponse<String> apiResponse = new ApiResponse<String>();
		ApiResponseHeader header = new ApiResponseHeader();
		header.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		header.setResultMessage(ApiCommonCode.API_RESULT_SUCCESS_MSG);

		apiResponse.setHeader(header);

		if (result == true) {
			apiResponse.setBody("Y");
		} else {
			apiResponse.setBody("N");
		}
		return apiResponse;
	}
}
