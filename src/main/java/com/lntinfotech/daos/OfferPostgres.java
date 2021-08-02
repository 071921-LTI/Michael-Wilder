package com.lntinfotech.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


}
