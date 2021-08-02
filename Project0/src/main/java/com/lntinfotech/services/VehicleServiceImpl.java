package com.lntinfotech.services;

import java.util.List;

import com.lntinfotech.daos.VehicleDao;
import com.lntinfotech.daos.VehiclePostgres;
import com.lntinfotech.models.Vehicles;

public class VehicleServiceImpl implements VehicleService {

	VehicleDao vd = new VehiclePostgres();
	@Override
	public List<Vehicles> getVehicle() {
		return vd.getVehicle();
	}

	
}
