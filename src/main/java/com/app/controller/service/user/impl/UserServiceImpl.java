package com.app.controller.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.controller.dao.user.UserDAO;
import com.app.controller.service.user.UserService;
import com.app.dto.user.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired  //의존성 주입 어노테이션
	UserDAO userDAO;

	@Override
	public int saveUser(User user) {
		
		int result = userDAO.saveUser(user);
		return result;
	}

	@Override
	public int saveCustomerUser(User user) {
		user.setUserType("CUS");
		int result = userDAO.saveUser(user);		
		return result;
	}

	@Override
	public int saveAdminUser(User user) {
		user.setUserType("ADM");
		int result = userDAO.saveUser(user);
		return result;
	}

}
