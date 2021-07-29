package com.lntinfotech.daos;

import java.util.List;


import com.lntinfotech.models.User;

public interface UserDao {

	public abstract User getUserById(int id);
	public abstract List<User> getUser();
	public abstract int addUser(User user);
	public abstract boolean updateUser(User user);
	public abstract User getUserByEmail(String email);

}
