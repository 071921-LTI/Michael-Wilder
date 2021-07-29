package com.lntinfotech.services;

import com.lntinfotech.exceptions.AuthException;
import com.lntinfotech.models.Employee;
import com.lntinfotech.models.User;

public interface AuthService {

	boolean login(User toBeChecked) throws AuthException;

	boolean login(Employee toBeChecked) throws AuthException;

}
