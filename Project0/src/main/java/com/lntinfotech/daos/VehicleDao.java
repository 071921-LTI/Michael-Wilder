package com.lntinfotech.daos;

import java.sql.Date;
import java.util.List;

import com.lntinfotech.models.Vehicles;

public interface VehicleDao {
	public abstract Vehicles getVehiclesByVIN(String vin);
	public abstract Vehicles getVehiclesByYear(Date year);
	public abstract List<Vehicles> getVehicle();
	public abstract int addVehicles(Vehicles vehicles);
	public abstract boolean updateVehicles(Vehicles vehicles);
	public abstract int deleteVehicles(int id);
	public abstract Vehicles getVehiclesByMakeAndModel(String make, String model);
}
