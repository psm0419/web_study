package com.app.controller.study;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.study.DrinkItem;
import com.app.dto.study.Member;

@Controller
public class JstkController {

	@GetMapping("/jstl/jstl1")
	public String jstl1(Model model) {

		model.addAttribute("msg", "이것은 메시지다");

		DrinkItem d1 = new DrinkItem();
		d1.setItem("아메리카노");
		d1.setType("커피");

		model.addAttribute("d1", d1);

		List<DrinkItem> drinkList = new ArrayList<>();
		drinkList.add(new DrinkItem("카페라떼", "커피"));
		drinkList.add(new DrinkItem("카페모카", "커피"));
		drinkList.add(new DrinkItem("카푸치노", "커피"));
		drinkList.add(new DrinkItem("아이스티", "차"));
		drinkList.add(new DrinkItem("레몬티", "차"));

		model.addAttribute("drinkList", drinkList);

		// userType : user, admin
		model.addAttribute("userType", "admin");

		model.addAttribute("isLogin", true); // true = 로그인O

		return "/jstl/jstl1";
	}

	@GetMapping("/jstl/jstl2")
	public String jstl2(Model model) {

		model.addAttribute("msg1", "<부등호>");
		model.addAttribute("msg2", "&lt;부등호&gt;");

		model.addAttribute("msgXml", "<script>alert('경고')</script>");
		return "/jstl/jstl2";
	}

	@GetMapping("/jstl/listTest")
	public String listTest(Model model, @RequestParam String type) {
		// 1)전부 화면에 전달
//		List<Member> memberList = new ArrayList<>();

//		memberList.add(new Member("아이디1","비번1","이름1"));
//		memberList.add(new Member("아이디2","비번2","이름2"));
//		memberList.add(new Member("아이디3","비번3","이름3"));
//		memberList.add(new Member("아이디4","비번4","이름4"));
//		memberList.add(new Member("아이디5","비번5","이름5"));		

//		for (int i = 1; i <= 5; i++) {
//			memberList.add(new Member("아이디" + i, "비번" + i, "이름" + i));
//		}
//
//		model.addAttribute("memberList", memberList);
//		model.addAttribute("type", type); // str, member

		// 2)조건걸어서
		List<Member> memberList = new ArrayList<>();
		model.addAttribute("type", type); // str, member
		
		if(type.equals("member")) {
			for (int i = 1; i <= 5; i++) {
				memberList.add(new Member("아이디" + i, "비번" + i, "이름" + i));
			}
			model.addAttribute("memberList", memberList);			
		}
		// 3)페이지를 나눠서 return에 다른페이지 연결하면 됨
		

		return "/jstl/listTest";
	}
		
	@GetMapping("/jstl/listTest/member")
	public String listTest2(Model model, @RequestParam String type) {
		
		List<Member> memberList = new ArrayList<>();

		memberList.add(new Member("아이디1","비번1","이름1"));
		memberList.add(new Member("아이디2","비번2","이름2"));
		memberList.add(new Member("아이디3","비번3","이름3"));
		memberList.add(new Member("아이디4","비번4","이름4"));
		memberList.add(new Member("아이디5","비번5","이름5"));		

		for (int i = 1; i <= 5; i++) {
			memberList.add(new Member("아이디" + i, "비번" + i, "이름" + i));
		}

		model.addAttribute("memberList", memberList);
		model.addAttribute("type", type); // str, member
		
		return "/jstl/listTest";
	}
	
	@GetMapping("/jstl/listTest/str")
	public String listTest3(Model model, @RequestParam String type) {
		
		List<Member> memberList = new ArrayList<>();

		memberList.add(new Member("아이디1","비번1","이름1"));
		memberList.add(new Member("아이디2","비번2","이름2"));
		memberList.add(new Member("아이디3","비번3","이름3"));
		memberList.add(new Member("아이디4","비번4","이름4"));
		memberList.add(new Member("아이디5","비번5","이름5"));		

		for (int i = 1; i <= 5; i++) {
			memberList.add(new Member("아이디" + i, "비번" + i, "이름" + i));
		}

		model.addAttribute("memberList", memberList);
		model.addAttribute("type", type);
		
		return "/jstl/listTest";
	}
	
	@GetMapping("/re/listTest/{type}")
	public String listTestPath(@PathVariable String type, Model model) {
		
		List<Member> memberList = new ArrayList<>();

		memberList.add(new Member("아이디1","비번1","이름1"));
		memberList.add(new Member("아이디2","비번2","이름2"));
		memberList.add(new Member("아이디3","비번3","이름3"));
		memberList.add(new Member("아이디4","비번4","이름4"));
		memberList.add(new Member("아이디5","비번5","이름5"));		

		for (int i = 1; i <= 5; i++) {
			memberList.add(new Member("아이디" + i, "비번" + i, "이름" + i));
		}

		model.addAttribute("memberList", memberList);
		model.addAttribute("type", type);
		
		return "/jstl/listTest";
	}
}
