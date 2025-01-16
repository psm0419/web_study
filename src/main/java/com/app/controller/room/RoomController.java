package com.app.controller.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.controller.service.room.RoomService;
import com.app.dto.room.Room;

@Controller
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@GetMapping("/rooms")
	public String rooms(Model model) {
		//Controller -> (interface) -> service -> (interface) -> DAO
		//				 다형성개념
		//호실정보 준비
		List<Room> roomList = roomService.findRoomList();
		
		//화면에 전달
		model.addAttribute("roomList", roomList);
		
		//화면 연결
		return "room/rooms";
	}
}
