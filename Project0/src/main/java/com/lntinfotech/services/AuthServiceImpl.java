package com.lntinfotech.services;

import com.lntinfotech.daos.UserDao;
import com.lntinfotech.daos.UserPostgres;
import com.lntinfotech.exceptions.AuthException;
import com.lntinfotech.exceptions.UserNotFoundException;
import com.lntinfotech.models.Employee;
import com.lntinfotech.models.User;

public class AuthServiceImpl implements AuthService {
	private UserDao ud = new UserPostgres();
	
	// With this implementation AuthException isn't needed
	@Override
	public boolean login(User user) throws AuthException {
		User persistedUser = ud.getUserByEmail(user.getEmail());
		if(persistedUser.getPassword().equals(user.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean login(Employee toBeChecked) throws AuthException {
		// TODO Auto-generated method stub
		return false;
	}

}