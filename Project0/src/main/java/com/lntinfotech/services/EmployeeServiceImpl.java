package com.lntinfotech.services;

import java.util.List;

import com.lntinfotech.daos.EmployeeDao;
import com.lntinfotech.daos.EmployeePostgres;
import com.lntinfotech.daos.OfferDao;
import com.lntinfotech.daos.OfferPostgres;
import com.lntinfotech.daos.VehicleDao;
import com.lntinfotech.daos.VehiclePostgres;
import com.lntinfotech.exceptions.AuthException;
import com.lntinfotech.exceptions.UserNotFoundException;
import com.lntinfotech.models.Employee;
import com.lntinfotech.models.Offers;
import com.lntinfotech.models.Vehicles;


public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao ed = new EmployeePostgres();
	private VehicleDao vd = new VehiclePostgres();
	private OfferDao od = new OfferPostgres();
	@Override
	public boolean login(Employee employee) throws AuthException, UserNotFoundException {
		Employee persistedEmployee = ed.getEmployeeByEmail(employee.getEmail());
		if(persistedEmployee.getPassword().equals(employee.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String addVehicles(Vehicles vehicles) {
		return vd.addVehicles(vehicles);
	}
	@Override
	public int deleteVehicles(String vin) {
		return vd.deleteVehicles(vin);
	}
	@Override
	public int getIdByEmail1(String email) {
		return vd.getIdByEmail1(email);
	}
	@Override
	public List<Vehicles> getAllPayments() {
		return vd.getAllPayments();
	}
	@Override
	public boolean acceptedOffer(Offers offer, Vehicles vehicle) {
		return od.acceptOffer(offer, vehicle);
	}

	@Override
	public boolean rejectOffer(String vin, double offer) {
		return od.rejectOffer(vin, offer);
	}

	@Override
	public boolean rejectOfferById(int id) {
		return od.rejectOfferById(id);
	}

	@Override
	public List<Offers> getAllOffers() {
		return od.getAllOffers();
	}
	
	


}
