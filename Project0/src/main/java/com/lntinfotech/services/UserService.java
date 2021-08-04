package com.lntinfotech.services;

import java.util.List;

import com.lntinfotech.exceptions.AuthException;
import com.lntinfotech.exceptions.UserNotFoundException;
import com.lntinfotech.models.Offers;
import com.lntinfotech.models.User;

public interface UserService {
	public abstract int addUser(User user);
//	public abstract User getUserByEmail(String email) throws UserNotFoundException;
//	public abstract List<User> getUser();
//	public abstract User getUserById(int id);
	public boolean login(User user) throws AuthException, UserNotFoundException;
	public abstract int getIdByEmail1(String email);
	public String makeOffer(Offers Offer);
}
