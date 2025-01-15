package com.app.side;

import java.util.HashMap;
import java.util.Map;

public class SessionConcept {

	public static void main(String[] args) {
		
		//JSESSIONID 쿠키값 -> 내 session 영역 접근 -> session.setAttribute
		
		//key:JsessionId 값, value : 저장공간(storage)
		Map<String, SessionStorage> sessionMap
				= new HashMap<String, SessionStorage>();
		
		sessionMap.put("123a123", new SessionStorage());
		
		SessionStorage session = sessionMap.get("123a123");		
		session.setAttribute("sessionMsg", "여기가 세션 메시지");
		
		sessionMap.put("bbb222", new SessionStorage());
		
		sessionMap.get("123a123");
		sessionMap.get("bbb222");
	}
}

class SessionStorage {
	
	Map<String, String> storage;
	
	public SessionStorage() {
		storage = new HashMap<String, String>();
	}
	
	public void setAttribute(String key, String value) {
		storage.put(key, value);
	}
	
	public void removeAttribute(String key) {
		storage.remove(key);
	}
	
	public void invalidate() {
		storage.clear();
	}
}