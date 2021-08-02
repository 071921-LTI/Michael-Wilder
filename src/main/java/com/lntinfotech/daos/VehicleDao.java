package com.lntinfotech.daos;

import java.sql.Date;
import java.util.List;

import com.lntinfotech.models.Vehicles;

public interface VehicleDao {
	public abstract Vehicles getVehiclesByVIN(String vin);
	public abstract List<Vehicles> getVehiclesByYear(int year);
	public abstract List<Vehicles> getVehicle();
	public abstract String addVehicles(Vehicles vehicles);
	public abstract boolean updateVehicles(Vehicles vehicle);
	public abstract int deleteVehicles(String vin);
	public abstract List<Vehicles> getVehiclesByMakeAndModel(String make, String model);
	public abstract List<Vehicles> getVehiclesByMake(String make);
	public abstract List<Vehicles> getVehiclesByUser(int dlNum);
	public abstract List<Vehicles> getVehiclesByEmployee(int emplId);
	public abstract List<Vehicles> getVehiclesByOffers(boolean offers);

}
