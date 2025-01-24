package com.app.controller.study;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RestQuizController {

	@GetMapping("/rest/quiz1")
	public String quiz1() {
		return "rest/restQuiz";
	}

	@ResponseBody
	@GetMapping("/rest/quiz2")
	public String quiz2() {
		return "return text quiz2";
	}

	@ResponseBody
	@GetMapping("/rest/quiz3")
	public User quiz3() { // 객체 리턴 -> JSON 포맷 변환 -> 조건: jackson 라이브러리 존재
		User user = new User();
		user.setId("quizid");
		user.setPw("secret");
		user.setName("quiz이름");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);

		return user;
	}

//	@ResponseBody
//	@GetMapping("/rest/quiz3")
//	public String quiz3() {
//		JSONObject obj = new JSONObject();
//		obj.put("id", "quizid");
//		obj.put("pw", "secret");
//		obj.put("name", "quiz이름");
//		obj.put("userType", "CUS");
//
//		System.out.println(obj.toJSONString());
//		return obj.toJSONString();
//	}
//	@ResponseBody
//	@GetMapping("/rest/quiz3")	
//	public String quiz3() {
//		User user = new User();
//		user.setId("quizid");
//		user.setPw("secret");
//		user.setName("quiz이름");
//		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
//
//		ObjectMapper mapper = new ObjectMapper();
//		String jsonStr = null;
//		try {
//			jsonStr = mapper.writeValueAsString(user);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		return jsonStr;
//
//	}
}
