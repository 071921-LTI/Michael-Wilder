package com.lti.services;

import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;

public interface AuthService {
	User login(String username, String password) throws UserNotFoundException;
	boolean authorize(String token) throws UserNotFoundException;
	String createToken(User user);
}
