package com.app.controller.study.quiz09;

import org.springframework.stereotype.Repository;

@Repository
public interface RoomDAO {

	public int registerRoom(RoomDTO roomDTO);
    
}
