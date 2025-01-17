package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.controller.dao.room.RoomDAO;
import com.app.controller.dao.room.impl.RoomDAOImpl;
import com.app.controller.service.room.RoomService;
import com.app.controller.service.room.impl.RoomServiceImpl;

//@Configuration
public class BeanConfiguration {
	
	//RoomDAO roomDAO = new RoomDAOImpl();  이거와 같은 뜻
	@Bean
	public RoomDAO roomDAO() { //인터페이스 넣고 변수명 맞춰추기
		
		return new RoomDAOImpl();
	}
	
	@Bean
	public RoomService roomService(RoomDAO roomDAO) {
		//set을 통해서 주입
//		RoomServiceImpl roomService = new RoomServiceImpl();
//		roomService.setRoomDAO(roomDAO);
//		
//		return roomService;
		//생성자 통해서 주입
		return null;
	}
}
