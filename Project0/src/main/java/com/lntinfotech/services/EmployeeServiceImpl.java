package com.lntinfotech.services;

import com.lntinfotech.daos.EmployeeDao;
import com.lntinfotech.daos.EmployeePostgres;
import com.lntinfotech.exceptions.AuthException;
import com.lntinfotech.exceptions.UserNotFoundException;
import com.lntinfotech.models.Employee;


public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao ed = new EmployeePostgres();
	@Override
	public boolean login(Employee employee) throws AuthException, UserNotFoundException {
		Employee persistedEmployee = ed.getEmployeeByEmail(employee.getEmail());
		if(persistedEmployee.getPassword().equals(employee.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public Employee getEmployeeByEmail(String email) {
		return ed.getEmployeeByEmail(email);
	}
	


}
