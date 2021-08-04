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
import com.lntinfotech.services.UserServiceImpl;
import com.lntinfotech.services.VehicleServiceImpl;

@ExtendWith(MockitoExtension.class)
public class VehiclesTest{
	@Mock
	private EmployeeDao ed;
	@Mock
	private VehicleDao vd;
	@Mock
	private OfferDao od;
	@Mock
	private UserDao ud;
	@InjectMocks
	private VehicleServiceImpl vs;

	Vehicles vehicle = new Vehicles("XXXXXXXXXXXXXXXXX", 2000, "Fake", "Fake", 1.0, false, 1.0, 1, (new User(1)), (new Employee(1)));
	Vehicles vehicleAvail = new Vehicles("XXXXXXXXXXXXXXXXX", 2000, "Fake", "Fake", 1.0, false, 0.0, 0, (new User(0)), (new Employee(0)));
	
	@Test
	public void getVehicle() {
		List<Vehicles> expected = new ArrayList<>();
		expected.add(vehicle);
		Mockito.when(vd.getVehicle()).thenReturn(expected);
		assertEquals(expected.size(), vs.getVehicle().size());
	}
	@Test
	public void getAvailableVehicle() {
		List<Vehicles> expected = new ArrayList<>();
		expected.add(vehicleAvail);
		Mockito.when(vd.getAvailableVehicle()).thenReturn(expected);
		assertEquals(expected.size(), vs.getAvailableVehicle().size());
	}
	@Test
	public void getVehiclesByUser() {
		List<Vehicles> expected = new ArrayList<>();
		expected.add(vehicle);
		Mockito.when(vd.getVehiclesByUser(1)).thenReturn(expected);
		assertEquals(expected.size(), vs.getVehiclesByUser(1).size());
	}
	@Test
	public void updateVehicleOffer() {
		Mockito.when(vd.updateVehicleOffer(vehicle)).thenReturn(true);
		boolean expected = true;
		assertEquals(expected, vs.updateVehicleOffer(vehicle));
	}
}