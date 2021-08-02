package com.lntinfotech.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lntinfotech.models.Employee;
import com.lntinfotech.util.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao{

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * from employees where id = ?";
		Employee emp = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int empId = rs.getInt("id");
				String empl_first_name = rs.getString("empl_first_name");
				String empl_last_name = rs.getString("empl_last_name");
				String empl_email = rs.getString("empl_email");
				String empl_pass = rs.getString("empl_pass");
				emp = new Employee(empId, empl_first_name, empl_last_name, empl_email, empl_pass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select * from employees";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int empId = rs.getInt("id");
				String empl_first_name = rs.getString("empl_first_name");
				String empl_last_name = rs.getString("empl_last_name");
				String empl_email = rs.getString("empl_email");
				String empl_pass = rs.getString("empl_pass");
				Employee employee = new Employee(empId, empl_first_name, empl_last_name, empl_email, empl_pass);
				employees.add(employee);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public int addEmployee(Employee employee) {
		int id = -1;
		String sql = "insert into employees (empl_first_name, empl_last_name, empl_role, empl_salary, empl_email, empl_pass) values (?,?,?,?) returning id;";
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getPassword());
			
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
	public boolean updateEmployee(Employee employee) {
		String sql = "update employees set empl_first_name = ?, empl_last_name = ?, empl_email = ?, empl_pass = ? where id = ?";
		int rowsChanged = -1;
				
				try (Connection con = ConnectionUtil.getConnectionFromEnv()){
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, employee.getFirstName());
					ps.setString(2, employee.getLastName());
					ps.setString(3, employee.getEmail());
					ps.setString(4, employee.getPassword());
					ps.setInt(5, employee.getId());
					
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
	public int deleteEmployee(int id) {
		String sql = "delete from employees where id = ?;";
		int rowsChanged = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsChanged;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		String sql = "select * from employees where empl_email = ?";
		Employee emp = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int empId = rs.getInt("id");
				String empl_first_name = rs.getString("empl_first_name");
				String empl_last_name = rs.getString("empl_last_name");
				String empl_email = rs.getString("empl_email");
				String empl_pass = rs.getString("empl_pass");
				emp = new Employee(empId, empl_first_name, empl_last_name, empl_email, empl_pass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

}
