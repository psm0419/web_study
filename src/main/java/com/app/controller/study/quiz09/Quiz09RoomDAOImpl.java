package com.app.controller.study.quiz09;

import org.springframework.stereotype.Repository;

@Repository
public class Quiz09RoomDAOImpl implements Quiz09RoomDAO{

	@Override
	public int registerRoom(Quiz09RoomDTO roomDTO) {
		//DB 저장
		
		System.out.println("호텔 객실 등록: " + roomDTO.getRoomNumber() + ", " + roomDTO.getRoomType() + ", " + roomDTO.getPrice() + ", Available: " + roomDTO.isAvailable());
		return 1;
	}

}
