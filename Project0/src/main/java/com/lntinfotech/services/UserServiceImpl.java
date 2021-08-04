package com.lntinfotech.services;

import com.lntinfotech.exceptions.AuthException;
import com.lntinfotech.exceptions.UserNotFoundException;
import com.lntinfotech.models.Offers;
import com.lntinfotech.models.User;

import java.util.List;

import com.lntinfotech.daos.OfferDao;
import com.lntinfotech.daos.OfferPostgres;
import com.lntinfotech.daos.UserDao;
import com.lntinfotech.daos.UserPostgres;

public class UserServiceImpl implements UserService{

	private UserDao ud = new UserPostgres();
	private OfferDao od = new OfferPostgres();
	
	public int addUser(User user) {
		return ud.addUser(user);
	}


	public boolean login(User user) throws AuthException, UserNotFoundException{
	User persistedUser = ud.getUserByEmail(user.getEmail());
	if(persistedUser.getPassword().equals(user.getPassword())) {
		return true;
	} else {
		return false;
	}
	}

	
//	@Override
//	public List<User> getUser() {
//		return ud.getUser();
//	}
//
//	@Override
//	public User getUserById(int id) {
//		return ud.getUserById(id);
//	}
//
//	@Override
//	public User getUserByEmail(String email) throws UserNotFoundException {
//		return ud.getUserByEmail(email);
//	}


	@Override
	public int getIdByEmail1(String email) {
		return ud.getIdByEmail1(email);
	}


	@Override
	public String makeOffer(Offers Offer) {
		
		od.addOffer(Offer);
		return ("Your offer has been Sent");
	}



	

	
}
