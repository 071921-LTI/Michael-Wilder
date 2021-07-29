package com.lntinfotech.daos;

import java.sql.Date;
import java.util.List;

import com.lntinfotech.models.Vehicles;

public class VehiclePostgres implements VehicleDao{

	@Override
	public Vehicles getVehiclesByVIN(String vin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicles getVehiclesByYear(Date year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicles> getVehicle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addVehicles(Vehicles vehicles) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateVehicles(Vehicles vehicles) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteVehicles(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vehicles getVehiclesByMakeAndModel(String make, String model) {
		// TODO Auto-generated method stub
		return null;
	}

}
