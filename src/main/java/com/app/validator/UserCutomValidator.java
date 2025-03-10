package com.app.validator;

import org.springframework.validation.Errors;

import com.app.dto.user.User;
import com.app.dto.user.UserValidError;

public class UserCutomValidator {

	public static boolean validate(User user, UserValidError userValidError) {
		boolean result = true;
		
		if (user.getId() == null || user.getId().equals("") || user.getId().trim().length() == 0) {
			userValidError.setId("아이디 입력 안함");
			result = false;
		}

		if (user.getId().equals("admin")) {
			userValidError.setId("사용불가한 아이디입니다");
			result = false;
		}

		if (user.getPw().length() < 8 || user.getPw().length() > 12) {
			userValidError.setPw("8~12자리로 입력 해주세요");
			result = false;
		}
		
		
		return result;
	}
	
	
	public static void validate(User user, Errors errors) {

		if (user.getId() == null || user.getId().equals("") || user.getId().trim().length() == 0) {
			errors.rejectValue("id", "UserIdEmpty", "아이디 입력 안함");
		}

		if (user.getId().equals("admin")) {
			errors.rejectValue("id", "UserIdError", "사용 불가한 아이디입니다");
		}

		if (user.getPw().length() < 8 || user.getPw().length() > 12) {
			errors.rejectValue("pw", "UserPwSize", "8자리 이상 12자리 이하로 작성");
		}
	}
	//원하는 형태로 확장
	public static void validateLoginUser(User user) {

	}

	public static void validateAdminUser(User user) {

	}
}
