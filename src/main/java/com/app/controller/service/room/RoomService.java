package com.app.controller.service.room;

import java.util.List;

import com.app.dto.room.Room;

public interface RoomService {

	List<Room> findRoomList();
	
	int registerRoom(Room room);
	
	Room findByRoomId(int roomId);
	
	int removeRoom(int roomId);
}
