package com.app.controller.service.user;


import com.app.dto.user.User;

public interface UserService {

	int saveUser(User user);
	
	int saveCustomerUser(User user);
	int saveAdminUser(User user);
}
