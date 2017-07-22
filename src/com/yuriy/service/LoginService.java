package com.yuriy.service;

import java.util.HashMap;

import com.yuriy.dto.User;

public class LoginService {
	
	HashMap<String, String> users = new HashMap<String, String>();
	
	public LoginService() {
		users.put("yuriy", "Yuriy");
		users.put("aleph", "Aleph Null");
		users.put("arni", "Arnold Schwarzenegger");
	}
	
	public boolean authenticate(String userId, String password) {
		if (password == null || password.trim() == "") {
			return false;
		}
		return true;
	}
	
	public User getUserDetails(String userId) {
		User user = new User();
		user.setUserId(userId);
		user.setUserName(users.get(userId));
		return user;
	}

}
