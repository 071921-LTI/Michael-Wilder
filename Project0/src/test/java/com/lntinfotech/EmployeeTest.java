package com.lntinfotech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
import com.lntinfotech.models.Vehicles;
import com.lntinfotech.services.EmployeeServiceImpl;
import com.lntinfotech.services.VehicleServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeTest {

	@Mock
	private EmployeeDao ed;
	@Mock
	private VehicleDao vd;
	@Mock
	private OfferDao od;
	@InjectMocks
	private EmployeeServiceImpl es;
	@InjectMocks
	private VehicleServiceImpl vs;
	
	Vehicles vehicle = new Vehicles("XXXXXXXXXXXXXXXXX", 2000, "Fake", "Fake", 1.0);
	Vehicles vehicleAcc = new Vehicles("XXXXXXXXXXXXXXXXX", 1.0, 1, (new User(1)), (new Employee(1)));
	Offers offer = new Offers("Accepted");
	
	@Test
	public void login() throws AuthException, UserNotFoundException, IOException, SQLException {
		Mockito.when(ed.getEmployeeByEmail("mm.com")).thenReturn(new Employee(1, "first", "last", "mm.com",  "password"));
		boolean expected = true;
		assertEquals(expected, es.login(new Employee(1, "first", "last", "mm.com",  "password")));

	}
	@Test
	public void deleteVehicles() {
		Mockito.when(vd.deleteVehicles("XXXXXXXXXXXXXXXXX")).thenReturn(0);
		int expected = 0;
		assertEquals(expected, es.deleteVehicles("XXXXXXXXXXXXXXXXX"));

	
	}
	@Test
	public void getIdByEmail1() {
		Mockito.when(vd.getIdByEmail1("mm.com")).thenReturn(1);
		int expected = 1;
		assertEquals(expected, es.getIdByEmail1("mm.com"));

	
	}
	@Test
	public void addVehicle() {
		Mockito.when(vd.addVehicles(vehicle)).thenReturn("XXXXXXXXXXXXXXXXX");
		String expected = "XXXXXXXXXXXXXXXXX";
		assertEquals(expected, es.addVehicles(vehicle));
	}
	@Test
	public void acceptedOffer() {
		Mockito.when(od.acceptOffer(offer, vehicleAcc)).thenReturn(true);
		boolean expected = true;
		assertEquals(expected, es.acceptedOffer(offer, vehicleAcc));

	}
	public void rejectOffer() {
		Mockito.when(od.rejectOffer("XXXXXXXXXXXXXXXXX", 1.00)).thenReturn(true);
		boolean expected = true;
		assertEquals(expected, es.rejectOffer("XXXXXXXXXXXXXXXXX", 1.00));
	}
}
