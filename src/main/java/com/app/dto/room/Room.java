package com.app.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //아무것도 없는 생성자
@AllArgsConstructor // 다 들어간 생성자

//Getter
//Setter
//RequiredArgsConstructor
//ToString
//EqualsAndHashCode
//lombok.Value
@Data //위에거 하나의 세트로 다 넣어줌
public class Room {

	int roomId; //pk 기본키 식별자
	String buildingNumber; //동 이름
	int roomNumber; 
	int floor;
	int maxGuestCount;
	String viewType;
	
}
