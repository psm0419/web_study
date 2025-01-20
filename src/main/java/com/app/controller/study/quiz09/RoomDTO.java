package com.app.controller.study.quiz09;

import lombok.Data;

@Data
public class RoomDTO {
     String roomNumber;
     String roomType;
     int price;
     boolean isAvailable;
     
	public RoomDTO(String roomNumber, String roomType, int price, boolean isAvailable) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.price = price;
		this.isAvailable = isAvailable;
	}
}
