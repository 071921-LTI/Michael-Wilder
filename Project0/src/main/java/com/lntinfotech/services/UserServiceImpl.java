package com.lntinfotech.services;

import com.lntinfotech.exceptions.UserNotFoundException;
import com.lntinfotech.models.User;
import com.lntinfotech.daos.UserDao;
import com.lntinfotech.daos.UserPostgres;

public class UserServiceImpl implements UserService{

	private UserDao ud = new UserPostgres();
	
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public User getUser(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
