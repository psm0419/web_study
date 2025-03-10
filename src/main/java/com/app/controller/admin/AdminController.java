package com.app.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.common.CommonCode;
import com.app.controller.service.room.RoomService;
import com.app.controller.service.user.UserService;
import com.app.dto.room.Room;
import com.app.dto.user.User;
import com.app.dto.user.UserSearchCondition;

import lombok.extern.slf4j.Slf4j;

@Slf4j //로그사용 어노테이션
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
		} else {
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

	// 관리자 특정 객실에 대한 정보(상세페이지)
	// @GetMapping("/admin/roominfo") roominfo?roomId=2
	// @GetMapping("/admin/room/2") @GetMapping("/admin/room/30")

	@GetMapping("/admin/room/{roomId}")
	public String room(@PathVariable String roomId, Model model) {
		int roomIdInt = Integer.parseInt(roomId);

		Room room = roomService.findByRoomId(roomIdInt);

		model.addAttribute("room", room);

		return "admin/room";
	}

	// 객실 정보 삭제
	@GetMapping("/admin/removeRoom")
	public String removeRoom(HttpServletRequest request) {
		String roomId = request.getParameter("roomId");

		int roomIdInt = Integer.parseInt(roomId);

		int result = roomService.removeRoom(roomIdInt);
		if (result > 0) {
			return "redirect:/admin/rooms";
		} else {
			return "admin/rooms";
		}
	}

	// 객실 정보 수정
	@GetMapping("/admin/modifyRoom")
	public String modifyRoom(HttpServletRequest request) {
		String roomId = request.getParameter("roomId");
		int roomIdInt = Integer.parseInt(roomId);
		// roomId -> 해당 호실에 대한 정보 조회
		// 화면에 세팅
		Room room = roomService.findByRoomId(roomIdInt);
		request.setAttribute("room", room);

		return "admin/modifyRoom";
	}
	
	@PostMapping("/admin/modifyRoom")
	public String modifyRoomAction(Room room) {
		
		int result = roomService.modifyRoom(room);
		
		if (result > 0) { //수정 성공
			return "redirect:/admin/room/" + room.getRoomId();
		} else { //수정 실패
			return "redirect:/admin/modifyRoom?roomId=" + room.getRoomId();
		}
	}

	@GetMapping("/admin/users/add")
	public String add() {
		return "admin/users/saveUser";
	}

	@PostMapping("/admin/users/add")
	public String addAction(User user) {

		// 등록
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER); // 여기서 해도 되고
		int result = userService.saveUser(user);
//		int result = userService.saveCustomerUser(user); //서비스에서 해도 되고
		System.out.println(result);

		if (result > 0) {
			return "redirect:/admin/users";
		} else {
			return "admin/users/saveUser";
		}
	}

	@GetMapping("/admin/users")
	public String users(Model model, UserSearchCondition userSearchCondition) {
		System.out.println(userSearchCondition);
		
//		List<User> userList = userService.findUserList();
		List<User> userList = userService.findUserListBySearchCondition(userSearchCondition);

		model.addAttribute("userList", userList);
		model.addAttribute("userSearchCondition", userSearchCondition);

		return "admin/users/users";
	}
	
//	@GetMapping("/admin/users/user")
//	public String user(User user, Model model) {
//		
//		User user1 = userService.findUserById(user.getId());
//
//		model.addAttribute("user", user1);
//
//		return "admin/users/user";
//	}

	@GetMapping("/admin/users/{id}")
	public String modifyUser(@PathVariable String id, Model model) {		
		
		User user = userService.findUserById(id);

		model.addAttribute("user", user);

		return "admin/users/modifyUser";
	}
	
	@PostMapping("/admin/users/{id}")
	public String modifyUserAction(User user) {
		
		int result = userService.modifyUser(user);
		
		if (result > 0) { //수정 성공
			return "redirect:/admin/users";
		} else { //수정 실패
			return "redirect:/admin/users/modifyUser/" + user.getId();
		}
	}
}
