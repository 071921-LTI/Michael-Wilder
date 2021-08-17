package com.lti.daos;

import java.util.List;

import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;

public interface UserDao {
	User getUserById(int id) throws UserNotFoundException;
	// if no user is found
	User getUserByUsername(String username) throws UserNotFoundException;
	List<User> getUsers();
	// Should return the id generated
	User addUser(User user);
	// if no user is found
	int deleteUser(int id) throws UserNotFoundException;
	boolean update(User user);
}
