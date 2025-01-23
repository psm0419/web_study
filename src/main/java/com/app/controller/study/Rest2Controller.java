package com.app.controller.study;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController // @ResponseBody 붙인거처럼 텍스트만 리턴하게 해줌
public class Rest2Controller {

	@GetMapping("/rest/rest4")
	public String rest4() {
		return "rest/rest4";
	}

	@GetMapping("/rest/rest5")
	public String rest5() {
		return "rest 5 return text restcontroller";
	}

//	@GetMapping("/rest/rest6")
//	public String rest6() {
	// 단순 텍스트
	// return "abc, qwe, name1, CUS";

	// JSON 포맷(많은 데이터 전달 -> 표현 규칙 -> JSON)
//		{
//			"id":"abc",
//			"pw":"qwe",
//			"name":"name1",
//			"userType":"CUS"
//		}
	/*
	 * JSON 포맥으로 return 을 하려면? 1)직접 포맷대로 작성 return "{" +
	 * "//			\"id\":\"abc\"," + "//			\"pw\":\"qwe\"," +
	 * "//			\"name\":\"name1\"," + "//			\"userType\":\"CUS\"" +
	 * "//		}";
	 * 
	 * 2)JSON 활용을 도와주는 라이브러리 사용 1. json-simple
	 * 
	 * JSONObject obj = new JSONObject(); obj.put("id", "abc"); obj.put("pw",
	 * "qwe"); obj.put("name", "name1"); obj.put("userType", "CUS");
	 * 
	 * System.out.println(obj.toJSONString()); return obj.toJSONString();
	 * 
	 * 2. jackson 라이브러리
	 * 
	 * User user = new User(); user.setId("abc"); user.setPw("qwe");
	 * user.setName("name1"); user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
	 * 
	 * ObjectMapper mapper = new ObjectMapper(); String jsonStr = null; try {
	 * jsonStr = mapper.writeValueAsString(user); } catch (JsonProcessingException
	 * e) { e.printStackTrace(); } return jsonStr;
	 * 
	 * }
	 */
	@GetMapping("/rest/rest7")
	public User rest7() { // 객체 리턴 -> JSON 포맷 변환 -> 조건: jackson 라이브러리 존재
		User user = new User();
		user.setId("abc");
		user.setPw("qwe");
		user.setName("name1");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);

		return user;
	}
	
}
