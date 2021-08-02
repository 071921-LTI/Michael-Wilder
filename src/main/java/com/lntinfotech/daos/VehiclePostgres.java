package com.lntinfotech.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lntinfotech.models.Employee;
import com.lntinfotech.models.Offers;
import com.lntinfotech.models.User;
import com.lntinfotech.models.Vehicles;
import com.lntinfotech.util.ConnectionUtil;

public class VehiclePostgres implements VehicleDao {

	

	@Override
	public Vehicles getVehiclesByVIN(String vin) {
//		String sql = "select cars.vin \"cars.vin\", cars.car_year \"cars.car_year\", cars.make \"cars.make\", cars.model \"cars.model\", cars.price \"cars.price\", cars.offers \"cars.offers\", cars.remaining_bal \"cars.remaining_bal\", cars.length_con \"cars.length_con\", cars.user_id \"cars.user_id\", users.user_first_name \"users.user_first_name\", users.user_last_name \"users.user_last_name\", users.user_email \"users.user_email\", cars.empl_id \"cars.empl_id\", employees.empl_first_name \"employees.empl_first_name\", employees.empl_last_name \"employees.empl_last_name\", employees.empl_email \"employees.empl_email\" from cars join users on cars.user_id = users.user_id join employees on cars.empl_id = employees.id where cars.vin = ?";
		String sql = "select cars.vin \"cars.vin\", cars.car_year \"cars.car_year\", cars.make \"cars.make\", cars.model \"cars.model\", cars.price \"cars.price\", cars.offers \"cars.offers\", cars.remaining_bal \"cars.remaining_bal\", cars.length_con \"cars.length_con\", cars.user_id \"cars.user_id\", cars.empl_id \"cars.empl_id\" from cars where cars.vin = ?";
//		String sql = "Select * from cars where vin = ?";
		Vehicles vehicle = null;
		Employee em = new Employee();
		em.setToString1(true);
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vin); // 1 refers to first ? to parameterize

			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
//				String vin1 = rs.getString("cars.vin");
//				int year = rs.getInt("cars.car_year");
//				String make = rs.getString("cars.make");
//				String model = rs.getString("car.model");
//				double price = rs.getDouble("cars.price");
//				boolean offers = rs.getBoolean("cars.offers");
//				double remBal = rs.getDouble("cars.remaining_bal");
//				int lenRem = rs.getInt("cars.length_con");
				String vin1 = rs.getString("cars.vin");
				int year = rs.getInt("cars.car_year");
				String make = rs.getString("cars.make");
				String model = rs.getString("cars.model");
				double price = rs.getDouble("cars.price");
				boolean offers = rs.getBoolean("cars.offers");
				double remBal = rs.getDouble("cars.remaining_bal");
				int lenRem = rs.getInt("cars.length_con");
//				int userId1 = rs.getInt("cars.user_id");
//				int emplId1 = rs.getInt("empl_id");
				User u = new User(rs.getInt("cars.user_id"));
//				User u = new User(rs.getInt("cars.user_id"), rs.getString("users.user_first_name"), rs.getString("users.user_last_name"), rs.getString("users.user_email"));
				User uU = new User(0, null, null, null, null);
//				System.out.println(uU);
//				System.out.println(u);
//				System.out.println(u.equals(uU));
				Employee e = new Employee(rs.getInt("cars.empl_id"));
//				Employee e = new Employee(rs.getInt("cars.empl_id"), rs.getString("employees.empl_first_name"), rs.getString("employees.empl_last_name"), rs.getString("employees.empl_email"));
				Employee eE = new Employee(0, null, null, null, null);
//				System.out.println(eE);
//				System.out.println(e);
//				System.out.println(e.equals(eE));
//				int but = rs.getInt("cars.user_id");
				if(u.equals(uU)) {

					
//					System.out.println(vh.setToString1(true));
					vehicle = new Vehicles(vin1, year, make, model, price, offers);

				}else {

					
					vehicle = new Vehicles(vin1, year, make, model, price, offers, remBal, lenRem, u, e);
//					vehicle = new Vehicles(vin1, year, make, model, price, offers, remBal, lenRem, u, e);
					
				}
//				vehicle = new Vehicles(vin1, year, make, model, price, offers, remBal, lenRem, u, e);
//				vehicle = new Vehicles(vin1, year, make, model, price, offers, remBal, lenRem, userId1, emplId1);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicle;
	}

	@Override
	public List<Vehicles> getVehiclesByYear(int year) {
		List<Vehicles> vehicles = new ArrayList<>();
		String sql = "select cars.vin \"cars.vin\", cars.car_year \"cars.car_year\", cars.make \"cars.make\", cars.model \"cars.model\", cars.price \"cars.price\", cars.offers \"cars.offers\", cars.remaining_bal \"cars.remaining_bal\", cars.length_con \"cars.length_con\", cars.user_id \"cars.user_id\", cars.empl_id \"cars.empl_id\" from cars where cars.car_year = ?";
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, year); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Vehicles vh = new Vehicles();
//				vh.setToString1(true);
				User us = new User();
				us.setToString1(true);
				String vin1 = rs.getString("cars.vin");
				int year1 = rs.getInt("cars.car_year");
				String make = rs.getString("cars.make");
				String model = rs.getString("cars.model");
				double price = rs.getDouble("cars.price");
				boolean offers = rs.getBoolean("cars.offers");
				double remBal = rs.getDouble("cars.remaining_bal");
				int lenRem = rs.getInt("cars.length_con");
//				User u = new User(rs.getInt("offers.user_id"), rs.getString("users.user_first_name"), rs.getString("users.user_last_name"), rs.getString("users.user_email"));
				User u = new User(rs.getInt("cars.user_id"));
//				Employee e = new Employee(rs.getInt("cars.empl_id"), rs.getString("employees.empl_first_name"), rs.getString("employees.empl_last_name"), rs.getString("employees.empl_email"));
				Employee e = new Employee(rs.getInt("cars.empl_id"));
				
				Vehicles vehicle = new Vehicles(vin1, year1, make, model, price, offers, remBal, lenRem, u, e);
				vehicles.add(vehicle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicles;
	}

	@Override
	public List<Vehicles> getVehicle() {
		List<Vehicles> vehicles = new ArrayList<>();
//		String sql = "select cars.vin \"cars.vin\", cars.car_year \"cars.car_year\", cars.make \"cars.make\", cars.model \"cars.model\", cars.price \"cars.price\", cars.offers \"cars.offers\", cars.remaining_bal \"cars.remaining_bal\", cars.length_con \"cars.length_con\", cars.user_id \"cars.user_id\", users.user_first_name \"users.user_first_name\", users.user_last_name \"users.user_last_name\", users.user_email \"users.user_email\", cars.empl_id \"cars.empl_id\", employees.empl_first_name \"employees.empl_first_name\", employees.empl_last_name \"employees.empl_last_name\", employees.empl_email \"employees.empl_email\" from cars join users on cars.user_id = users.user_id join employees on cars.empl_id = employees.id";

		String sql = "select cars.vin \"cars.vin\", cars.car_year \"cars.car_year\", cars.make \"cars.make\", cars.model \"cars.model\", cars.price \"cars.price\", cars.offers \"cars.offers\", cars.remaining_bal \"cars.remaining_bal\", cars.length_con \"cars.length_con\", cars.user_id \"cars.user_id\", cars.empl_id \"cars.empl_id\" from cars order by offers";
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);

			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {

				String vin1 = rs.getString("cars.vin");
				int year1 = rs.getInt("cars.car_year");
				String make = rs.getString("cars.make");
				String model = rs.getString("cars.model");
				double price = rs.getDouble("cars.price");
				boolean offers = rs.getBoolean("cars.offers");
				double remBal = rs.getDouble("cars.remaining_bal");
				int lenRem = rs.getInt("cars.length_con");
//				User u = new User(rs.getInt("offers.user_id"), rs.getString("users.user_first_name"), rs.getString("users.user_last_name"), rs.getString("users.user_email"));
				User u = new User(rs.getInt("cars.user_id"));
//				Employee e = new Employee(rs.getInt("cars.empl_id"), rs.getString("employees.empl_first_name"), rs.getString("employees.empl_last_name"), rs.getString("employees.empl_email"));
				Employee e = new Employee(rs.getInt("cars.empl_id"));
				
				Vehicles vehicle = new Vehicles(vin1, year1, make, model, price, offers, remBal, lenRem, u, e);
				vehicles.add(vehicle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicles;
	}

	@Override
	public String addVehicles(Vehicles vehicles) {
		String id = null;
		String sql = "insert into cars (vin, car_year, make, model, price, offers) values (?,?,?,?,?,?) returning vin;";
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vehicles.getVin());
			ps.setInt(2, vehicles.getYear());
			ps.setString(3, vehicles.getMake());
			ps.setString(4, vehicles.getModel());
			ps.setDouble(5,  vehicles.getPrice());
			ps.setBoolean(6, false);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("vin");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public boolean updateVehicles(Vehicles vehicle) {
		String sql = "update cars set price = ?, offers = ?, remaining_bal = ?, length_con = ? , user_id = ?, empl_id = ? where vin = ?";
		int rowsChanged = -1;
				
				try (Connection con = ConnectionUtil.getConnectionFromEnv()){
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setDouble(1, vehicle.getPrice());
					ps.setBoolean(2, vehicle.isOffers());
					ps.setDouble(3, vehicle.getRemBal());
					ps.setInt(4, vehicle.getLenRem());
					ps.setInt(5, vehicle.getUserId().getUserId());
					ps.setInt(6, vehicle.getEmplId().getId());
					ps.setString(7, vehicle.getVin());
					
					rowsChanged = ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(rowsChanged >0) {
					return true;
				} 
				return false;
	}

	@Override
	public int deleteVehicles(String vin) {
		String sql = "delete from cars where vin = ?;";
		int rowsChanged = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vin);
			
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsChanged;
	}

	@Override
	public List<Vehicles> getVehiclesByMakeAndModel(String make, String model) {
		List<Vehicles> vehicles = new ArrayList<>();
		String sql = "select cars.vin \"cars.vin\", cars.car_year \"cars.car_year\", cars.make \"cars.make\", cars.model \"cars.model\", cars.price \"cars.price\", cars.offers \"cars.offers\", cars.remaining_bal \"cars.remaining_bal\", cars.length_con \"cars.length_con\", cars.user_id \"cars.user_id\", cars.empl_id \"cars.empl_id\" from cars where cars.make = ? and cars.model = ?";
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, make); // 1 refers to first ? to parameterize
			ps.setString(2, model);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Vehicles vh = new Vehicles();
//				vh.setToString1(true);
				User us = new User();
				us.setToString1(true);
				String vin1 = rs.getString("cars.vin");
				int year1 = rs.getInt("cars.car_year");
				String make1 = rs.getString("cars.make");
				String model1 = rs.getString("cars.model");
				double price = rs.getDouble("cars.price");
				boolean offers = rs.getBoolean("cars.offers");
				double remBal = rs.getDouble("cars.remaining_bal");
				int lenRem = rs.getInt("cars.length_con");
//				User u = new User(rs.getInt("offers.user_id"), rs.getString("users.user_first_name"), rs.getString("users.user_last_name"), rs.getString("users.user_email"));
				User u = new User(rs.getInt("cars.user_id"));
//				Employee e = new Employee(rs.getInt("cars.empl_id"), rs.getString("employees.empl_first_name"), rs.getString("employees.empl_last_name"), rs.getString("employees.empl_email"));
				Employee e = new Employee(rs.getInt("cars.empl_id"));
				
				Vehicles vehicle = new Vehicles(vin1, year1, make1, model1, price, offers, remBal, lenRem, u, e);
				vehicles.add(vehicle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicles;
	}

	@Override
	public List<Vehicles> getVehiclesByMake(String make) {
		List<Vehicles> vehicles = new ArrayList<>();
		String sql = "select cars.vin \"cars.vin\", cars.car_year \"cars.car_year\", cars.make \"cars.make\", cars.model \"cars.model\", cars.price \"cars.price\", cars.offers \"cars.offers\", cars.remaining_bal \"cars.remaining_bal\", cars.length_con \"cars.length_con\", cars.user_id \"cars.user_id\", cars.empl_id \"cars.empl_id\" from cars where cars.make = ?";
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, make); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Vehicles vh = new Vehicles();
//				vh.setToString1(true);
				User us = new User();
				us.setToString1(true);
				String vin1 = rs.getString("cars.vin");
				int year1 = rs.getInt("cars.car_year");
				String make1 = rs.getString("cars.make");
				String model = rs.getString("cars.model");
				double price = rs.getDouble("cars.price");
				boolean offers = rs.getBoolean("cars.offers");
				double remBal = rs.getDouble("cars.remaining_bal");
				int lenRem = rs.getInt("cars.length_con");
//				User u = new User(rs.getInt("offers.user_id"), rs.getString("users.user_first_name"), rs.getString("users.user_last_name"), rs.getString("users.user_email"));
				User u = new User(rs.getInt("cars.user_id"));
//				Employee e = new Employee(rs.getInt("cars.empl_id"), rs.getString("employees.empl_first_name"), rs.getString("employees.empl_last_name"), rs.getString("employees.empl_email"));
				Employee e = new Employee(rs.getInt("cars.empl_id"));
				
				Vehicles vehicle = new Vehicles(vin1, year1, make1, model, price, offers, remBal, lenRem, u, e);
				vehicles.add(vehicle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicles;
	}

	@Override
	public List<Vehicles> getVehiclesByUser(int userId) {
		List<Vehicles> vehicles = new ArrayList<>();
		String sql = "select cars.vin \"cars.vin\", cars.car_year \"cars.car_year\", cars.make \"cars.make\", cars.model \"cars.model\", cars.price \"cars.price\", cars.offers \"cars.offers\", cars.remaining_bal \"cars.remaining_bal\", cars.length_con \"cars.length_con\", cars.user_id \"cars.user_id\", cars.empl_id \"cars.empl_id\" from cars where cars.user_id = ?";
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Vehicles vh = new Vehicles();
//				vh.setToString1(true);
				User us = new User();
				us.setToString1(true);
				String vin1 = rs.getString("cars.vin");
				int year1 = rs.getInt("cars.car_year");
				String make = rs.getString("cars.make");
				String model = rs.getString("cars.model");
				double price = rs.getDouble("cars.price");
				boolean offers = rs.getBoolean("cars.offers");
				double remBal = rs.getDouble("cars.remaining_bal");
				int lenRem = rs.getInt("cars.length_con");
//				User u = new User(rs.getInt("offers.user_id"), rs.getString("users.user_first_name"), rs.getString("users.user_last_name"), rs.getString("users.user_email"));
				User u = new User(rs.getInt("cars.user_id"));
//				Employee e = new Employee(rs.getInt("cars.empl_id"), rs.getString("employees.empl_first_name"), rs.getString("employees.empl_last_name"), rs.getString("employees.empl_email"));
				Employee e = new Employee(rs.getInt("cars.empl_id"));
				
				Vehicles vehicle = new Vehicles(vin1, year1, make, model, price, offers, remBal, lenRem, u, e);
				vehicles.add(vehicle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicles;
	}

	@Override
	public List<Vehicles> getVehiclesByEmployee(int emplId) {
		List<Vehicles> vehicles = new ArrayList<>();
		String sql = "select cars.vin \"cars.vin\", cars.car_year \"cars.car_year\", cars.make \"cars.make\", cars.model \"cars.model\", cars.price \"cars.price\", cars.offers \"cars.offers\", cars.remaining_bal \"cars.remaining_bal\", cars.length_con \"cars.length_con\", cars.user_id \"cars.user_id\", cars.empl_id \"cars.empl_id\" from cars where cars.empl_id = ?";
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, emplId); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Vehicles vh = new Vehicles();
//				vh.setToString1(true);
				User us = new User();
				us.setToString1(true);
				String vin1 = rs.getString("cars.vin");
				int year1 = rs.getInt("cars.car_year");
				String make = rs.getString("cars.make");
				String model = rs.getString("cars.model");
				double price = rs.getDouble("cars.price");
				boolean offers = rs.getBoolean("cars.offers");
				double remBal = rs.getDouble("cars.remaining_bal");
				int lenRem = rs.getInt("cars.length_con");
//				User u = new User(rs.getInt("offers.user_id"), rs.getString("users.user_first_name"), rs.getString("users.user_last_name"), rs.getString("users.user_email"));
				User u = new User(rs.getInt("cars.user_id"));
//				Employee e = new Employee(rs.getInt("cars.empl_id"), rs.getString("employees.empl_first_name"), rs.getString("employees.empl_last_name"), rs.getString("employees.empl_email"));
				Employee e = new Employee(rs.getInt("cars.empl_id"));
				
				Vehicles vehicle = new Vehicles(vin1, year1, make, model, price, offers, remBal, lenRem, u, e);
				vehicles.add(vehicle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicles;
	}

	@Override
	public List<Vehicles> getVehiclesByOffers(boolean offers) {
		List<Vehicles> vehicles = new ArrayList<>();
		String sql = "select cars.vin \"cars.vin\", cars.car_year \"cars.car_year\", cars.make \"cars.make\", cars.model \"cars.model\", cars.price \"cars.price\", cars.offers \"cars.offers\", cars.remaining_bal \"cars.remaining_bal\", cars.length_con \"cars.length_con\", cars.user_id \"cars.user_id\", cars.empl_id \"cars.empl_id\" from cars where cars.offers = ?";
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, offers); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Vehicles vh = new Vehicles();
//				vh.setToString1(true);
				User us = new User();
				us.setToString1(true);
				String vin1 = rs.getString("cars.vin");
				int year1 = rs.getInt("cars.car_year");
				String make = rs.getString("cars.make");
				String model = rs.getString("cars.model");
				double price = rs.getDouble("cars.price");
				boolean offers1 = rs.getBoolean("cars.offers");
				double remBal = rs.getDouble("cars.remaining_bal");
				int lenRem = rs.getInt("cars.length_con");
//				User u = new User(rs.getInt("offers.user_id"), rs.getString("users.user_first_name"), rs.getString("users.user_last_name"), rs.getString("users.user_email"));
				User u = new User(rs.getInt("cars.user_id"));
//				Employee e = new Employee(rs.getInt("cars.empl_id"), rs.getString("employees.empl_first_name"), rs.getString("employees.empl_last_name"), rs.getString("employees.empl_email"));
				Employee e = new Employee(rs.getInt("cars.empl_id"));
				
				Vehicles vehicle = new Vehicles(vin1, year1, make, model, price, offers1, remBal, lenRem, u, e);
				vehicles.add(vehicle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicles;
	}

	

}
