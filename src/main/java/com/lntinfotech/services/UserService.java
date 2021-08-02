package com.lntinfotech.services;

import java.util.List;

import com.lntinfotech.exceptions.AuthException;
import com.lntinfotech.exceptions.UserNotFoundException;
import com.lntinfotech.models.Employee;
import com.lntinfotech.models.User;

public interface UserService {
	public abstract int addUser(User user);
	public abstract User getUserByEmail(String email) throws UserNotFoundException;
	public abstract List<User> getUser();
	public abstract User getUserById(int id);
	//public abstract User login(String email, String password);
	public boolean login(User user) throws AuthException, UserNotFoundException;
	
}
