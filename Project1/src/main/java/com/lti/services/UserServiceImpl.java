package com.lti.services;

import java.util.List;

import com.lti.daos.UserDao;
import com.lti.daos.UserHibernate;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;

public class UserServiceImpl implements UserService{
	UserDao ud = new UserHibernate();
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) throws UserNotFoundException {
		return ud.getUserById(id);
	}

}
