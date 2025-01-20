package com.app.controller.study.quiz09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	public RoomDAO roomDAO;
	
	@Override
	public int registerRoom(RoomDTO roomDTO) {
		System.out.println("객실 등록 서비스 시작");
        int result = roomDAO.registerRoom(roomDTO);
        System.out.println("객실 등록 서비스 완료");
        
        return result;
	}

}
