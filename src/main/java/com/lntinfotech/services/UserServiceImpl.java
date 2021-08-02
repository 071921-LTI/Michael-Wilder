package com.lntinfotech.services;

import com.lntinfotech.exceptions.AuthException;
import com.lntinfotech.exceptions.UserNotFoundException;
import com.lntinfotech.models.Employee;
import com.lntinfotech.models.User;

import java.util.List;

import com.lntinfotech.daos.UserDao;
import com.lntinfotech.daos.UserPostgres;

public class UserServiceImpl implements UserService{

	private UserDao ud = new UserPostgres();
	
	public int addUser(User user) {
		return ud.addUser(user);
	}

	public User getUser(String email) throws UserNotFoundException {
		return ud.getUserByEmail(email);
	}

	public boolean login(User user) throws AuthException, UserNotFoundException{
	User persistedUser = ud.getUserByEmail(user.getEmail());
	if(persistedUser.getPassword().equals(user.getPassword())) {
		return true;
	} else {
		return false;
	}
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	

	
}
