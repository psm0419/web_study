package com.app.controller.service.user;


import java.util.List;

import com.app.dto.user.User;

public interface UserService {

	int saveUser(User user);
	List<User> findUserList();
	
	
	int saveCustomerUser(User user);
	int saveAdminUser(User user);
}
