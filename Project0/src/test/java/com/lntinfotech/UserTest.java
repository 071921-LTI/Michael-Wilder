package com.lntinfotech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lntinfotech.daos.EmployeeDao;
import com.lntinfotech.daos.OfferDao;
import com.lntinfotech.daos.UserDao;
import com.lntinfotech.daos.VehicleDao;
import com.lntinfotech.exceptions.AuthException;
import com.lntinfotech.exceptions.UserNotFoundException;
import com.lntinfotech.models.Employee;
import com.lntinfotech.models.Offers;
import com.lntinfotech.models.User;
import com.lntinfotech.services.EmployeeServiceImpl;
import com.lntinfotech.services.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserTest {
	@Mock
	private EmployeeDao ed;
	@Mock
	private VehicleDao vd;
	@Mock
	private OfferDao od;
	@Mock
	private UserDao ud;
	@InjectMocks
	private UserServiceImpl us;

	@Test
	public void login() throws AuthException, UserNotFoundException, IOException, SQLException {
		Mockito.when(ud.getUserByEmail("bf.com")).thenReturn(new User(1, "Bob", "Forapples", "bf.com",  "password"));
		boolean expected = true;
		assertEquals(expected, us.login(new User(1, "Bob", "Forapples", "bf.com",  "password")));

	}

	@Test
	public void getIdByEmail1() {
		Mockito.when(ud.getIdByEmail1("bf.com")).thenReturn(1);
		int expected = 1;
		assertEquals(expected, us.getIdByEmail1("bf.com"));

	
	}
	@Test
	public void makeOffer() {
		Mockito.when(od.addOffer(new Offers(1.00))).thenReturn(0);
		String expected = "Your offer has been Sent";
		assertEquals(expected, us.makeOffer(new Offers(1.00)));
	}
}
