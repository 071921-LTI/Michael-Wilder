package com.lti.services;

import com.lti.daos.UserHibernate;
import com.lti.daos.UserDao;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;

public class AuthServiceImpl implements AuthService{
	UserDao ud = new UserHibernate();

	@Override
	public User login(String username, String password) throws UserNotFoundException {
		User user = ud.getUserByUsername(username);
		if (user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public boolean authorize(String token) throws UserNotFoundException {
	String[] stringArr = token.split(":");
	int id = Integer.parseInt(stringArr[0]);
	String role = stringArr[1];
		User user = ud.getUserById(id);
		if(!user.getRoleId().equals(role)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String createToken(User user) {
		String token = "";
		
		token = user.getUserId()+":"+user.getRoleId();
		
		return token;
	}
}
