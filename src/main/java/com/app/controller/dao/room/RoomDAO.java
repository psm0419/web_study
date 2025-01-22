package com.app.controller.dao.room;

import java.util.List;

import com.app.dto.room.Room;

public interface RoomDAO {

	List<Room> findRoomList();		
		
	int registerRoom(Room room);
	
	Room findByRoomId(int roomId);
	
	int removeRoom(int roomId);
	
	int modifyRoom(Room room);
	
}
