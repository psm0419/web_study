package com.app.controller.dao.user;

import java.util.List;

import com.app.dto.user.User;
import com.app.dto.user.UserProfileImage;
import com.app.dto.user.UserSearchCondition;

public interface UserDAO {

	int saveUser(User user);
	List<User> findUserList();
	
	User findUserById(String id);
	
	User checkUserLogin(User user);
	
	int modifyUser(User user);
	
	List<User> findUserListBySearchCondition(UserSearchCondition userSearchCondition);
	
	public int saveUserProfileImage(UserProfileImage userProfileImage);
	
	public UserProfileImage findUserProfileImageById(String id);
}
