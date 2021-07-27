package com.lntinfotech.services;

import com.lntinfotech.daos.UserDao;
import com.lntinfotech.daos.UserFile;
import com.lntinfotech.exceptions.AuthException;
import com.lntinfotech.exceptions.UserNotFoundException;
import com.lntinfotech.models.User;

public class AuthServiceImpl implements AuthService {
	private UserDao ud = new UserFile();
	
	// With this implementation AuthException isn't needed
	@Override
	public boolean login(User user) throws AuthException {
		User persistedUser = ud.getUser(user.getUsername());
		if(persistedUser.getPassword().equals(user.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

}