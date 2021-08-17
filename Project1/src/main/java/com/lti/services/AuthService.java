package com.lti.services;



import com.lti.exceptions.UserNotFoundException;
import com.lti.exceptions.LoginException;
import com.lti.models.User;

public interface AuthService {
	String login(String username, String password) throws UserNotFoundException, LoginException;
	String authorize(String token) throws UserNotFoundException;

}
