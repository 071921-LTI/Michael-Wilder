package com.lti.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.NoResultException;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lti.daos.UserDao;
import com.lti.exceptions.LoginException;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.Roles;
import com.lti.models.User;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
	Roles empl = new Roles(2, "Employee");
	User user = new User("User", "password", "first", "last", "fl.com", empl);
	
	@Mock
	UserDao ud;
	
	@InjectMocks
	AuthServiceImpl as;
	
	@Test
	public void loginValid() throws LoginException, UserNotFoundException {
		Mockito.when(ud.getUserByUsername("User")).thenReturn(user);
		assertEquals("User:Employee", as.login("User", "password"));
	}
	
	@Test
	public void loginBad() throws UserNotFoundException {
		Mockito.when(ud.getUserByUsername("User")).thenReturn(user);
		assertThrows(LoginException.class, () -> as.login("User", "badpass"));
	}
	
	@Test
	public void authorizeValid() throws UserNotFoundException {
		assertEquals("User", as.authorize("User:Employee"));
	}
	
	@Test
	public void authorizeInvalid() throws UserNotFoundException {
		assertNull(as.authorize(null));
	}
}
