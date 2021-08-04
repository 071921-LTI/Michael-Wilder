package com.lntinfotech.services;

import java.util.List;

import com.lntinfotech.exceptions.AuthException;
import com.lntinfotech.exceptions.UserNotFoundException;
import com.lntinfotech.models.Employee;
import com.lntinfotech.models.Offers;
import com.lntinfotech.models.Vehicles;


public interface EmployeeService {

	public boolean login(Employee employee) throws AuthException, UserNotFoundException;

//	public Employee getEmployeeByEmail(String email);

	public abstract String addVehicles(Vehicles vehicles);
	
	public abstract int deleteVehicles(String vin);
	
	public abstract int getIdByEmail1(String email);
	
	public abstract List<Vehicles> getAllPayments();
	
	public boolean acceptedOffer(Offers offer, Vehicles vehicle);
	public boolean rejectOffer(String vin, double offer);

}
