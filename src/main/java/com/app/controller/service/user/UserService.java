package com.app.controller.service.user;


import java.util.List;

import com.app.dto.user.User;
import com.app.dto.user.UserProfileImage;
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
	
	/**
	 * 아이디 중복 여부 체크
	 * @param id 중복 여부 체크하는 user id
	 * @return 중복 여부 확인(true: 중복, false: 사용가능)
	 */
	boolean isDuplicatedId(String id);
	
	int saveUserProfileImage(UserProfileImage userProfileImage);
	
	public UserProfileImage findUserProfileImageById(String id);
}
