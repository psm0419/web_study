package com.app.controller.service.room.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.controller.dao.room.RoomDAO;
import com.app.controller.service.room.RoomService;
import com.app.dto.room.Room;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	RoomDAO roomDAO;
	
	@Override
	public List<Room> findRoomList() {
		
		List<Room> roomList	= roomDAO.findRoomList();
		
		return roomList;
	}

	
}
