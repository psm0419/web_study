package com.app.controller.service.room.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.controller.dao.room.RoomDAO;
import com.app.controller.service.room.RoomService;
import com.app.dto.room.Room;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired  //의존성 주입 어노테이션
	RoomDAO roomDAO;
	//생성자를 통한 주입
//	public RoomServiceImpl(RoomDAO roomDAO) {
//		this.roomDAO = roomDAO;
//	}
//	//set을 통한 주입
//	public void setRoomDAO(RoomDAO roomDAO) {
//		this.roomDAO = roomDAO;
//	}
	@Override
	public List<Room> findRoomList() {
		
		List<Room> roomList	= roomDAO.findRoomList();
		System.out.println("RoomService 호출됨");
		return roomList;
	}

	
}
