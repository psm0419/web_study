package com.app.controller.study;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.ApiCommonCode;
import com.app.common.CommonCode;
import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.study.api.ApiDelivery;
import com.app.dto.study.api.ApiMenu;
import com.app.dto.study.api.ApiResponseDelivery;
import com.app.dto.study.api.ApiStore;
import com.app.dto.user.User;

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
	 * @GetMapping("/rest/rest7() public User rest7() { User user = new User();
	 * user.setId("abc"); user.setPw("qwe"); user.setName("name1");
	 * user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
	 * 
	 * ObjectMapper mapper = new ObjectMapper(); String jsonStr = null; try {
	 * jsonStr = mapper.writeValueAsString(user); } catch (JsonProcessingException
	 * e) { e.printStackTrace(); } return jsonStr;
	 * 
	 * }
	 */
	@GetMapping("/rest/rest8")
	public User rest8() { // 객체 리턴 -> JSON 포맷 변환 -> 조건: jackson 라이브러리 존재
		User user = new User();
		user.setId("abc");
		user.setPw("qwe");
		user.setName("name1");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);

		return user;
	}

	@GetMapping("/rest/rest9")
	public List<ApiMenu> rest9() {
		List<ApiMenu> menuList = new ArrayList<ApiMenu>();
		ApiMenu am1 = new ApiMenu();
		am1.setName("식혜");
		am1.setPrice(3000);

		menuList.add(am1);
		menuList.add(new ApiMenu("아이스티", 2500));
		menuList.add(new ApiMenu("아메리카노", 2000));
		menuList.add(new ApiMenu("카페라떼", 3500));

		return menuList;
	}

	@GetMapping("/rest/rest10")
	public ApiDelivery rest10() {
		ApiDelivery apiDelivery = new ApiDelivery();

		apiDelivery.setStaffName("나배달");
		apiDelivery.setDetination("로하스 7층");
		apiDelivery.setPhone("010-1234-1234");

		ApiStore apiStore = new ApiStore();
		apiStore.setName("롯데리아");
		apiStore.setAdress("대흥동 399-5번지 1층");
		apiStore.setTel("02-112-3344");

		apiDelivery.setApistore(apiStore);

		List<ApiMenu> menuList = new ArrayList<ApiMenu>();
		menuList.add(new ApiMenu("치즈버거", 3000));
		menuList.add(new ApiMenu("라이스버거", 4000));
		menuList.add(new ApiMenu("불고기버거", 5000));
		
		apiDelivery.setMenuList(menuList);

		return apiDelivery;
	}
	
	@GetMapping("/rest/rest11")
	public ApiDelivery rest11() {
		//10 정상
		//20 일시적문제
		//30 등등
		return null;
	}
	
	@GetMapping("/rest/rest12")
	public ApiResponseHeader rest12() {
		ApiResponseHeader apiResponseHeader = new ApiResponseHeader();
//		apiResponseHeader.setResultCode("10");
//		apiResponseHeader.setResultMessage("정상");
		apiResponseHeader.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		apiResponseHeader.setResultMessage(ApiCommonCode.API_RESULT_SUCCESS_MSG);
		
		
		return apiResponseHeader;
	}
	
	@GetMapping("/rest/rest13")
	public ApiResponseDelivery rest13() {
		ApiResponseHeader apiResponseHeader = new ApiResponseHeader();
		apiResponseHeader.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		apiResponseHeader.setResultMessage(ApiCommonCode.API_RESULT_SUCCESS_MSG);
		
		ApiDelivery apiDelivery = new ApiDelivery();

		apiDelivery.setStaffName("나배달");
		apiDelivery.setDetination("로하스 7층");
		apiDelivery.setPhone("010-1234-1234");

		ApiStore apiStore = new ApiStore();
		apiStore.setName("롯데리아");
		apiStore.setAdress("대흥동 399-5번지 1층");
		apiStore.setTel("02-112-3344");

		apiDelivery.setApistore(apiStore);

		List<ApiMenu> menuList = new ArrayList<ApiMenu>();
		menuList.add(new ApiMenu("치즈버거", 3000));
		menuList.add(new ApiMenu("라이스버거", 4000));
		menuList.add(new ApiMenu("불고기버거", 5000));
		
		apiDelivery.setMenuList(menuList);
		
		ApiResponseDelivery res = new ApiResponseDelivery();
		res.setHeader(apiResponseHeader);
		res.setBody(apiDelivery);
		
		
		
		return res;
	}
	
	@GetMapping("/rest/rest14")
	public ApiResponse<User> rest14() {
//		ApiResponse<String> ar1;
//		ApiResponse<ApiMenu> ar2;
//		ApiResponse<ApiDelivery> ar3;
		
		ApiResponse<User> res = new ApiResponse<User>();
		
		ApiResponseHeader apiResponseHeader = new ApiResponseHeader();
		apiResponseHeader.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		apiResponseHeader.setResultMessage(ApiCommonCode.API_RESULT_SUCCESS_MSG);
		
		res.setHeader(apiResponseHeader);
		
		User user = new User();
		user.setId("idid");
		user.setName("sdname");
		user.setPw("03sdadf");
		user.setUserType(CommonCode.USER_USERTYPE_ADMIN);
		
		res.setBody(user);
		
		return res;
	}
}
