package com.lntinfotech.services;

import java.util.List;

import com.lntinfotech.daos.UserDao;
import com.lntinfotech.daos.UserPostgres;
import com.lntinfotech.daos.VehicleDao;
import com.lntinfotech.daos.VehiclePostgres;
import com.lntinfotech.models.User;
import com.lntinfotech.models.Vehicles;

public class VehicleServiceImpl implements VehicleService {

	VehicleDao vd = new VehiclePostgres();
	UserDao ud = new UserPostgres();
	@Override
	public List<Vehicles> getVehicle() {
		return vd.getVehicle();
	}
	@Override
	public List<Vehicles> getAvailableVehicle() {
		return vd.getAvailableVehicle();
	}
	@Override
	public List<Vehicles> getVehiclesByUser(int userId) {
		return vd.getVehiclesByUser(userId);
	}

	@Override
	public String getRemainingWeeklyPayments(int userId) {
		return ("The remaining balance is: " + vd.getRemainingB(userId) + " your remaining number of payments is: " + vd.getRemainingWeeks(userId) + " your weekly payment is: " + vd.getRemainingB(userId)/vd.getRemainingWeeks(userId));
		
	}
	public boolean updateVehicleOffer(Vehicles Vehicle) {
		return vd.updateVehicleOffer(Vehicle);
	}
}
	
