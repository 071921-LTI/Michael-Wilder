package com.lntinfotech.services;

import com.lntinfotech.exceptions.AuthException;
import com.lntinfotech.exceptions.UserNotFoundException;
import com.lntinfotech.models.Employee;
import com.lntinfotech.models.User;

public interface EmployeeService {

	public boolean login(Employee employee) throws AuthException, UserNotFoundException;

	public Employee getEmployeeByEmail(String email);

}
