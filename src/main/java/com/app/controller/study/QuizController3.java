package com.app.controller.study;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.study.Member;

@Controller
public class QuizController3 {

	@GetMapping("/manage/member")
	public String quiz06(Model model, @RequestParam String auth) {
		
		// 넘긴다음 페이지에서 필터링
		ArrayList<Member> memberList = new ArrayList<Member>();

		memberList.add(new Member("user1", "pass123", "홍길동", "basic"));
		memberList.add(new Member("user2", "pass456", "김철수", "manager"));
		memberList.add(new Member("user3", "pass789", "이영희", "basic"));
		memberList.add(new Member("user4", "passabc", "박민지", "manager"));
		memberList.add(new Member("user5", "passdef", "정재영", "basic"));
		memberList.add(new Member("user6", "passxyz", "최성민", "basic"));
		memberList.add(new Member("user7", "pass123", "서지원", "manager"));
		memberList.add(new Member("user8", "pass456", "장성호", "basic"));
		memberList.add(new Member("user9", "pass789", "신지수", "basic"));
		memberList.add(new Member("user10", "passabc", "한영희", "manager"));
		
		model.addAttribute("auth", auth); // basic, manager
		model.addAttribute("memberList", memberList);	
		
		//서버에서 필터링해서 넘기는 방법
		ArrayList<Member> viewMemberList = new ArrayList<Member>();
		
		for(Member member : memberList) {
			//한번에 하는 방법
//			if(auth.equals(member.getType()) || auth.equals("admin")){
//				viewMemberList.add(member);
//			}
			if(auth.equals("basic")) {
				if(member.getType().equals("basic")) {
					viewMemberList.add(member);
				}
			}
			if(auth.equals("manager")) {
				if(member.getType().equals("manager")) {
					viewMemberList.add(member);
				}
			}
			if(auth.equals("admin")) {
				viewMemberList.add(member);				
			}			
		}
		model.addAttribute("viewMemberList", viewMemberList);
		
		return "/quiz/quiz06/Quiz06";
	}
	
}
