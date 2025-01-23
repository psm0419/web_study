package com.app.controller.service.user.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.CommonCode;
import com.app.controller.dao.user.UserDAO;
import com.app.controller.service.user.UserService;
import com.app.dto.user.User;
import com.app.dto.user.UserSearchCondition;

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
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		int result = userDAO.saveUser(user);		
		return result;
	}

	@Override
	public int saveAdminUser(User user) {
		user.setUserType(CommonCode.USER_USERTYPE_ADMIN);
		int result = userDAO.saveUser(user);
		return result;
	}

	@Override
	public List<User> findUserList() {
		
		List<User> userList	= userDAO.findUserList();
		return userList;
	}

	@Override
	public User checkUserLogin(User user) {
		// 1) 서비스 자체에서 로직을 수행
//		User loginUser =  userDAO.findUserById(user.getId());
//		
//		if(loginUser != null && user.getPw().equals(loginUser.getPw()) 
//				&& loginUser.getUserType().equals(user.getUserType())) {
//			return loginUser;
//		}
//		return null;
		//아이디, 비번이 맞으면 loginUser
		//아이디X 또는 아이디O 비번X -> null
		
//		if(loginUser == null) { //해당 id에 맞는 계정이 없다
//			return null;
//		} else { //계정이 있다
//			if(user.getPw().equals(loginUser.getPw())) {
//				return loginUser;
//			}
//		}
//		return null;
		
		// 2) DAO-> Mapper 쿼리를 만들어서 비교하는 방법
		User loginUser = userDAO.checkUserLogin(user);
		
		return loginUser;
	}

	@Override
	public User findUserById(String id) {
		
		User user = userDAO.findUserById(id);
		return user;
	}

	@Override
	public int modifyUser(User user) {
		int result = userDAO.modifyUser(user);
		return result;
	}

	@Override
	public List<User> findUserListBySearchCondition(UserSearchCondition userSearchCondition) {
		
		List<User> userList = userDAO.findUserListBySearchCondition(userSearchCondition);
		
		return userList;
	}

}
