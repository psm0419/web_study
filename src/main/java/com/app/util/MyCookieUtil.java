package com.app.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class MyCookieUtil {
//	리팩토링 전
//	public static String getCookie(Cookie[] cookies, String cookieName) {
//		for (Cookie ck : cookies) {
//			if (ck.getName().equals(cookieName)) {
//				return ck.getValue();
//			}
//		}
//		return null;
//	}
//	//메소드 오버라이딩
//	public static String getCookie(HttpServletRequest request, String cookieName) {
//		Cookie[] cookies = request.getCookies();		
//		for (Cookie ck : cookies) {
//			if (ck.getName().equals(cookieName)) {
//				return ck.getValue();
//			}
//		}
//		return null;
//	}

//	리팩토링 후
	public static String getCookie(Cookie[] cookies, String cookieName) {
		try {
			for (Cookie ck : cookies) {
				if (ck.getName().equals(cookieName)) {
					String cookieValue = URLDecoder.decode(ck.getValue(), "UTF-8");
					return cookieValue;
				}
			}
		} catch (Exception e) {

		}
		return null;
	}

	// 메소드 오버라이딩
	public static String getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		return getCookie(cookies, cookieName);
	}
	
	public static String encodeCookieValue(String value) {
		try {
			return URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Cookie createCookie(String name, String value) {
		Cookie ck = new Cookie(name, encodeCookieValue(value));
		return ck;
	}
	//메소드 오버라이딩
	public static Cookie createCookie(String name, String value, int ageSecond) {
		
//		Cookie ck = createCookie(name, value);
		
		Cookie ck = new Cookie(name, encodeCookieValue(value));
		ck.setMaxAge(ageSecond);
		return ck;
	}
			
}
