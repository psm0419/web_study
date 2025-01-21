package com.app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.app.controller.service.room.RoomService;
import com.app.controller.service.user.UserService;
import com.app.dto.room.Room;

@Controller
public class AdminController {

	@Autowired
	RoomService roomService;
	@Autowired
	UserService userService;

	// 객실 등록
	@GetMapping("/admin/registerRoom")
	public String registerRoom() {
		return "admin/registerRoom";
	}

	@PostMapping("/admin/registerRoom")
	public String registerRoomAction(Room room) {
		// 값 넘어온것 확인
		System.out.println(room.toString());

		// 등록
		int result = roomService.registerRoom(room);

		System.out.println(result);

		if (result > 0) {
			return "redirect:/admin/rooms";
		}else {
			return "admin/registerRoom";
		}

		
	}

	// 고객 관리/등록
	@GetMapping("/admin/rooms")
	public String rooms(Model model) {
		List<Room> roomList = roomService.findRoomList();
		// service.findRoomList 호출 -> DAO findRoomList -> DB(my batis mapper) select
		// controller db 조회데이터 -> 화면 전달 -> 화면 출력
		model.addAttribute("roomList", roomList);

		return "admin/rooms";
	}

}
