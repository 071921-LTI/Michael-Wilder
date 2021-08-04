package com.lntinfotech.daos;

import java.sql.Date;
import java.util.List;

import com.lntinfotech.models.Vehicles;

public interface VehicleDao {
	public abstract Vehicles getVehiclesByVIN(String vin);
	public abstract List<Vehicles> getVehiclesByYear(int year);
	public abstract List<Vehicles> getVehicle();
	public abstract List<Vehicles> getAvailableVehicle();
	public abstract List<Vehicles> getVehiclesByEmail(String email);
	public abstract String addVehicles(Vehicles vehicles);
	public abstract boolean updateVehicles(Vehicles vehicle);
	public abstract int deleteVehicles(String vin);
	public abstract List<Vehicles> getVehiclesByMakeAndModel(String make, String model);
	public abstract List<Vehicles> getVehiclesByMake(String make);
	public abstract List<Vehicles> getVehiclesByUser(int userId);
	public abstract List<Vehicles> getVehiclesByEmployee(int emplId);
	public abstract List<Vehicles> getVehiclesByOffers(boolean offers);
	public abstract List<Vehicles> getRemaingingPayments(int userId);
	public abstract double getRemainingB(int userId);
	public abstract int getRemainingWeeks(int userId);
	public abstract boolean updateVehicleOffer(Vehicles Vehicle);
	public abstract int getIdByEmail1(String email);
	public abstract List<Vehicles> getAllPayments();
//	public abstract boolean acceptedVehicles(Vehicles vehicle);
}
