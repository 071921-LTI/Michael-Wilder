package com.lti.services;

import com.lti.daos.UserHibernate;



import com.lti.daos.UserDao;
import com.lti.exceptions.UserNotFoundException;
import com.lti.exceptions.LoginException;
import com.lti.models.User;

public class AuthServiceImpl implements AuthService{
	UserDao ud = new UserHibernate();

	public static String createToken(User user) {
		return user.getUsername() + ":" + user.getRoleId().getUserRole();
	}
	@Override
	public String login(String username, String password) throws UserNotFoundException, LoginException {
		User user = ud.getUserByUsername(username);
		if (!user.getPassword().equals(password)) {
			throw new LoginException();
		} else {
			
			return createToken(user);
		}
	}

	@Override
	public String authorize(String token) throws UserNotFoundException {
		if (token == null) {
			return null;
		} else {
			System.out.println("here"+token);
			return token.split(":")[0];
		}
	}


}
