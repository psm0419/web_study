package com.app.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.util.MyCookieUtil;

@Controller
public class CookieController {

	@GetMapping("/save-cookie")
	public String saveCookie(HttpServletResponse response) {
		//서버에서 쿠키 생성 -> 사용자
		
		Cookie ck1 = new Cookie("weather", "snowing");
		ck1.setMaxAge(60*60*12); //쿠키수명 초단위		
		response.addCookie(ck1);
		
		//띄어쓰기 -> URL Encode   띄어쓰기 -> %20
		String tempValue;
		try {
			tempValue = URLEncoder.encode("temp cookie value", "UTF-8");
			
			Cookie ck2 = new Cookie("temp", tempValue);//띄어쓰기 안됨
			response.addCookie(ck2);			
			
			Cookie ck3 = new Cookie("temp2", MyCookieUtil.encodeCookieValue("22 calue test"));
			
			Cookie ck4 = MyCookieUtil.createCookie("ckName", "ckValue");
			response.addCookie(ck4);
			
			Cookie ck5 = MyCookieUtil.createCookie("ck5Name", "ck5Value", 120);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "cookie/save-cookie";
	}
	
	@GetMapping("/remove-cookie")
	public String removeCookie(HttpServletResponse response) {
		Cookie ck1 = new Cookie("temp", "value");
		ck1.setMaxAge(0); //0초 유지라 삭제하라는 의미
		response.addCookie(ck1);
		
		
		return "cookie/save-cookie";
	}
	
	@GetMapping("/read-cookie")
	public String readCookie(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
//		for(Cookie ck : cookies) {
//			System.out.println(ck.getName() +" "+ ck.getValue());
//			
//			if(ck.getName().equals("weather")) {
//				request.setAttribute("weather", ck.getValue());
//			}
//		}
		String weather =  MyCookieUtil.getCookie(cookies, "weather");
		if(weather != null)
			System.out.println(weather);
		
		String temp = MyCookieUtil.getCookie(request, "temp");
		
		
		return "cookie/read-cookie";
	}
	
	@GetMapping("/read-cookie2")			//@CookieValue 가져올때 디코딩 따로 해줘야함
	public String readCookie2(@CookieValue String weather, @CookieValue String temp) {
		
			System.out.println(weather);
			System.out.println(temp);
			String decodeTemp;
			try {
				decodeTemp = URLDecoder.decode(temp, "UTF-8");
				System.out.println(decodeTemp);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		
		return "cookie/read-cookie";
	}
}
