package com.lti.services;

import java.util.List;

import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;

public interface UserService {
	boolean addUser(User user);
	List<User> getUsers();
	User getUserById(int id) throws UserNotFoundException;
	User getUserByUsername(String username) throws UserNotFoundException;
	boolean update(User user);

}
