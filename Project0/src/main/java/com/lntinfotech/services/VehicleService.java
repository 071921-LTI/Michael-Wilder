package com.lntinfotech.services;

import java.util.List;

import com.lntinfotech.models.User;
import com.lntinfotech.models.Vehicles;

public interface VehicleService {

	public abstract List<Vehicles> getVehicle();
	public abstract List<Vehicles> getAvailableVehicle();
	public abstract List<Vehicles> getVehiclesByUser(int userId);
//	public abstract List<Vehicles> getVehiclesByEmail(String email);
	public abstract String getRemainingWeeklyPayments(int userId);
	public boolean updateVehicleOffer(Vehicles Vehicle);
	
}
