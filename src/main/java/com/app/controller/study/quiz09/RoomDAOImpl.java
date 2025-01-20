package com.app.controller.study.quiz09;

public class RoomDAOImpl implements RoomDAO{

	@Override
	public int registerRoom(RoomDTO roomDTO) {
		//DB 저장
		
		System.out.println("호텔 객실 등록: " + roomDTO.getRoomNumber() + ", " + roomDTO.getRoomType() + ", " + roomDTO.getPrice() + ", Available: " + roomDTO.isAvailable());
		return 1;
	}

}
