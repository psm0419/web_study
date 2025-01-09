package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Request01Controller {
	@RequestMapping("/url1")
	public String url1() {//이름 안맞아도 됨
		
	return "url1"; //그 이름을 가지고 있는 view 파일을 명시
	}
	
	@RequestMapping("/url2")
	public String url2() {
		
	return "home"; //그 이름을 가지고 있는 view 파일을 명시
	}
	
	@RequestMapping("/url3")
	public String url3() {
		
	return "url1"; //그 이름을 가지고 있는 view 파일을 명시
	}
	
	@RequestMapping("/url4") //그냥 쓰면 get, post 둘다 수신
	public String url4() {
		
	return "url/url4"; //폴더안에 있으면 폴더까지 써주면 됨
	}
	
	//HTTP 통신 Method = GET, POST, DELETE, PUT, PATCH
	@RequestMapping(value = "/url5", method = RequestMethod.GET)
	//명시하면 그것만 받음
	public String url5() {
		
	return "url/url4"; //폴더안에 있으면 폴더까지 써주면 됨
	}
	@RequestMapping(value = "/url6", method = RequestMethod.POST)
	public String url6() {
		
	return "url/url4"; //폴더안에 있으면 폴더까지 써주면 됨
	}
	@GetMapping("/url7") //겟매핑
	public String url7() {
		
	return "url/url4"; //폴더안에 있으면 폴더까지 써주면 됨
	}
	@PostMapping("/url8") //포스트매핑
	public String url8() {
		
	return "url/url4"; //폴더안에 있으면 폴더까지 써주면 됨
	}
}
