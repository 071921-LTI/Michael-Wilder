package com.lti.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import com.lti.daos.UserDao;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.Roles;
import com.lti.models.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	Roles empl = new Roles(2, "Employee");
	User user = new User("User", "password", "first", "last", "fl.com", empl);
	
	@Mock
	UserDao ud;
	
	@InjectMocks
	private UserServiceImpl us;
	
	@Test
	public void getUserByUsernameExist() throws UserNotFoundException {
		Mockito.when(ud.getUserByUsername(user.getUsername())).thenReturn(user);
		assertEquals(user, us.getUserByUsername(user.getUsername()));
	}
	
	@Test
	public void getUserById() throws UserNotFoundException {
		Mockito.when(ud.getUserById(user.getUserId())).thenReturn(user);
		assertEquals(user, us.getUserById(user.getUserId()));
	}
	
	@Test
	public void updateUserExist() {
		Mockito.when(ud.update(user)).thenReturn(true);
		assertEquals(true, us.update(user));
	}
	
	@Test
	public void updateUserNotExist() {
		Mockito.when(ud.update(user)).thenReturn(false);
		assertEquals(us.update(user), false);
	}
	
	
}
