package com.lntinfotech.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lntinfotech.models.Employee;
import com.lntinfotech.models.Offers;
import com.lntinfotech.models.User;
import com.lntinfotech.models.Vehicles;
import com.lntinfotech.util.ConnectionUtil;

public class OfferPostgres implements OfferDao{

	@Override
	public List<Offers> getOffersByVIN(String vin) {
		List<Offers> offers = new ArrayList<>();
		Vehicles vh = new Vehicles();
//		vh.setToString1(true);
		User us = new User();
		us.setToString1(true);
		String sql = "select offers.id \"offers.id\", offers.status \"offers.status\", offers.offer \"offers.offer\", offers.vin \"offers.vin\", cars.car_year \"cars.car_year\", cars.make\"cars.make\", cars.model\"cars.model\", cars.price\"cars.price\", offers.user_id\"offers.user_id\", users.user_first_name\"users.user_first_name\", users.user_last_name\"users.user_last_name\", users.user_email \"users.user_email\" from offers join cars on offers.vin = cars.vin join users on offers.user_id = users.user_id where offers.vin = ?";
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vin); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("offers.id");
				String stat = rs.getString("offers.status");
				double offer = rs.getDouble("offers.offer");

				Vehicles c = new Vehicles(rs.getString("offers.vin"), rs.getInt("cars.car_year"), rs.getString("cars.make"), rs.getString("cars.model"), rs.getDouble("cars.price"));
				User u = new User(rs.getInt("offers.user_id"), rs.getString("users.user_first_name"), rs.getString("users.user_last_name"), rs.getString("users.user_email"));
				
				Offers off = new Offers(id, stat, offer, c, u);
				offers.add(off);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offers;
	}

	
	@Override
	public List<Offers> getOffersByUserId(int userId) {

		List<Offers> offers = new ArrayList<>();
		String sql = "select offers.id \"offers.id\", offers.status \"offers.status\", offers.offer \"offers.offer\", offers.vin \"offers.vin\", cars.vin \"cars.vin\" ,cars.car_year \"cars.car_year\", cars.make\"cars.make\", cars.model\"cars.model\", cars.price\"cars.price\", offers.user_id\"offers.user_id\", users.user_first_name\"users.user_first_name\", users.user_last_name\"users.user_last_name\", users.user_email \"users.user_email\" from offers join cars on offers.vin = cars.vin join users on offers.user_id = users.user_id where offers.user_id = ?";
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Vehicles vh = new Vehicles();
//				vh.setToString1(true);
				User us = new User();
				us.setToString1(true);
				int id = rs.getInt("offers.id");
				String stat = rs.getString("offers.status");
				double offer = rs.getDouble("offers.offer");
				Vehicles c = new Vehicles(rs.getString("offers.vin"), rs.getInt("cars.car_year"), rs.getString("cars.make"), rs.getString("cars.model"), rs.getDouble("cars.price"));
				
				User u = new User(rs.getInt("offers.user_id"), rs.getString("users.user_first_name"), rs.getString("users.user_last_name"), rs.getString("users.user_email"));
				
				Offers off = new Offers(id, stat, offer, c, u);
				offers.add(off);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offers;
	}


	@Override
	public int addOffer(Offers offer) {
		int id = -1;
		String sql = "insert into offers (status, offer, vin, user_id) values (?,?,?,?) returning id;";
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "Pending");
			ps.setDouble(2, offer.getOffer());
			ps.setString(3, offer.getVin().getVin());
			ps.setInt(4, offer.getUserId().getUserId());

			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}


	@Override
	public List<Offers> getOffersByStatus(String status) {
		List<Offers> offers = new ArrayList<>();
		Vehicles vh = new Vehicles();
//		vh.setToString1(true);
		User us = new User();
		us.setToString1(true);
		String sql = "select offers.id \"offers.id\", offers.status \"offers.status\", offers.offer \"offers.offer\", offers.vin \"offers.vin\", cars.car_year \"cars.car_year\", cars.make\"cars.make\", cars.model\"cars.model\", cars.price\"cars.price\", offers.user_id\"offers.user_id\", users.user_first_name\"users.user_first_name\", users.user_last_name\"users.user_last_name\", users.user_email \"users.user_email\" from offers join cars on offers.vin = cars.vin join users on offers.user_id = users.user_id where offers.status = ?";
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, status); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("offers.id");
				String stat = rs.getString("offers.status");
				double offer = rs.getDouble("offers.offer");

				Vehicles c = new Vehicles(rs.getString("offers.vin"), rs.getInt("cars.car_year"), rs.getString("cars.make"), rs.getString("cars.model"), rs.getDouble("cars.price"));
				User u = new User(rs.getInt("offers.user_id"), rs.getString("users.user_first_name"), rs.getString("users.user_last_name"), rs.getString("users.user_email"));
				
				Offers off = new Offers(id, stat, offer, c, u);
				offers.add(off);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offers;
	}


	@Override
	public boolean acceptOffer(Offers offer, Vehicles vehicle) {
		String sql = "update offers set status = ? where id = ? ";
		String sql1 = "update cars set offers = ?, remaining_bal = ?, length_con = ?, user_id = ?, empl_id =? where vin = ?";

		int rowsChanged = -1;
		int rowsChanged1 = -1;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "Accepted");
			ps.setInt(2, offer.getId());
			
			rowsChanged = ps.executeUpdate();
			
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setBoolean(1, false);
			ps1.setDouble(2, vehicle.getRemBal());
			ps1.setInt(3, 60);
			ps1.setInt(4, vehicle.getUserId().getUserId());
			ps1.setInt(5, vehicle.getEmplId().getId());
			ps1.setString(6, vehicle.getVin());
			
			rowsChanged1 = ps1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged > 0 && rowsChanged1 > 0) {
			return true;
		} 
		return false;
	}


	@Override
	public Offers getOfferById(int id) {
		String sql = "select * from offers where id = ?";
		Offers offered = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id1 = rs.getInt("id");
				String status = rs.getString("status");
				double offer = rs.getDouble("offer");
				User u = new User(rs.getInt("user_id"));
				Vehicles v = new Vehicles(rs.getString("vin"));
				offered = new Offers(id1, status, offer, v, u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offered;
	}


	@Override
	public double offerAmount(int id) {
		String sql = "select offer from offers where id = ?";
			double offered = 0;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {

				offered = rs.getDouble("offer");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offered;
	}


	@Override
	public int userId(int id) {
		String sql = "select user_id from offers where id = ?";
		int userid = 0;
	try(Connection con = ConnectionUtil.getConnectionFromEnv()){
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id); // 1 refers to first ? to parameterize
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {

			userid = rs.getInt("user_id");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return userid;
	}


	@Override
	public String vinById(int id) {
		String sql = "select vin from offers where id = ?";
		String vinId = null;
	try(Connection con = ConnectionUtil.getConnectionFromEnv()){
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id); // 1 refers to first ? to parameterize
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {

			vinId = rs.getString("vin");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return vinId;
	}


	@Override
	public boolean rejectOffer(String vin, double offer) {
		String sql = "update offers set status = ? where vin = ? and offer != ? ";

		int rowsChanged = -1;

		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "Rejected");
			ps.setString(2, vin);
			ps.setDouble(3, offer);
			rowsChanged = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged > 0) {
			return true;
		} 
		return false;
	}


	@Override
	public boolean rejectOfferById(int id) {
		String sql = "update offers set status = ? where id = ? ";

		int rowsChanged = -1;

		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "Rejected");
			ps.setInt(2, id);
			rowsChanged = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged > 0) {
			return true;
		} 
		return false;
	}


	@Override
	public List<Offers> getAllOffers() {
List<Offers> offered = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select * from offers order by status";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String status = rs.getString("status");
				double offer = rs.getDouble("offer");
				User u = new User(rs.getInt("user_id"));

				Offers offers = new Offers(id, status, offer, u);
				offered.add(offers);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offered;
	}
	
	
}
