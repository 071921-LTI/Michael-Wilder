package com.lntinfotech.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lntinfotech.models.Employee;
import com.lntinfotech.models.User;
import com.lntinfotech.util.ConnectionUtil;

public class UserPostgres implements UserDao {

	@Override
	public User getUserById(int userId) {
		String sql = "select * from users where user_id = ?";
		User user = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("user_Id");
				String user_first_name = rs.getString("user_first_name");
				String user_last_name = rs.getString("user_last_name");
				String user_email = rs.getString("user_email");
				String user_pass = rs.getString("user_pass");
				user = new User(id, user_first_name, user_last_name, user_email, user_pass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getUser() {
		List<User> users = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select * from users";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("user_Id");
				String user_first_name = rs.getString("user_first_name");
				String user_last_name = rs.getString("user_last_name");
				String user_email = rs.getString("user_email");
				String user_pass = rs.getString("user_pass");
				User user = new User(id, user_first_name, user_last_name, user_email, user_pass);
				users.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public int addUser(User user) {
		int id = -1;
		String sql = "insert into users (user_first_name, user_last_name, user_email, user_pass) values (?,?,?,?) returning user_id;";
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("user_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public boolean updateUser(User user) {
		String sql = "update users set user_first_name = ?, user_last_name = ?, user_email = ?, user_pass = ? where user_id = ?";
		int rowsChanged = -1;
				
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getUserId());
					
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
	public User getUserByEmail(String email) {
		String sql = "select * from users where user_email = ?";
		User user = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("user_Id");
				String user_first_name = rs.getString("user_first_name");
				String user_last_name = rs.getString("user_last_name");
				String user_email = rs.getString("user_email");
				String user_pass = rs.getString("user_pass");
				user = new User(id, user_first_name, user_last_name, user_email, user_pass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String getPassword(String password) {
		// TODO Auto-generated method stub
				return null;
		
	}

	@Override
	public User getIdByEmail(String email) {
		String sql = "select user_id from users where email = ?";
		User user = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id1 = rs.getInt("user_Id");
				
				String user_email = rs.getString("user_email");
				
				user = new User(id1, user_email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int getIdByEmail1(String email) {
		int id = -1;
		String sql = "Select * from users where user_email = ?;";
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("user_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}


}
