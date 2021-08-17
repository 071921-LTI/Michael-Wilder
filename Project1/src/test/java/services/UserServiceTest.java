package services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lti.daos.UserDao;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;
import com.lti.models.Roles;
import com.lti.services.UserService;
import com.lti.services.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	Roles empl = new Roles(2, "Employee");
	User user = new User("newUser", "password", "first", "last", "nu.com", empl);
	
	@Mock
	UserDao ud;
	
	
	
	

	
//	@Test
//	public void getUserByUsernameExist() throws UserNotFoundException {
//		Mockito.when(ud.getUserByUsername(user.getUsername())).thenReturn(user);
//		assertEquals(user, us.getUserByUsername(user.getUsername()));
//	}
//	



	

}