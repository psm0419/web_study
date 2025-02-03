package com.app.controller.service.user;


import java.util.List;

import com.app.dto.user.User;
import com.app.dto.user.UserSearchCondition;

public interface UserService {

	int saveUser(User user);
	
	List<User> findUserList();
	
	User findUserById(String id);
	User checkUserLogin(User user);
	
	int saveCustomerUser(User user);
	int saveAdminUser(User user);
	
	int modifyUser(User user);
	
	List<User> findUserListBySearchCondition(UserSearchCondition userSearchCondition);
	
	boolean isDuplicatedId(String id);
}
