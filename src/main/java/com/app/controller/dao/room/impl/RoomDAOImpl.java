package com.app.controller.dao.room.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.controller.dao.room.RoomDAO;
import com.app.dto.room.Room;

//Data 읽어오는 역할 DB접근역할		DAO(DB), Repository(외부)
// APIServiceRepository
@Repository	//bean 등록 Annotation
public class RoomDAOImpl implements RoomDAO{

	@Override
	public List<Room> findRoomList() {
		
		System.out.println("RoomDAO 호출됨");
		//db 연결 조회
		
		return null;
	}

	@Override
	public int registerRoom(Room room) {
		
		return 0;
		
	}
}
