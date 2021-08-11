package com.lti.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;
import com.lti.util.HibernateUtil;


public class UserHibernate implements UserDao{

	@Override
	public User getUserById(int id) throws UserNotFoundException {
		User u = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			u = s.get(User.class, id);
		}
		return u;
	}

	@Override
	public User getUserByUsername(String username) throws UserNotFoundException {
		User u = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			u = s.get(User.class, username);
		}
		return u;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(User user) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(user);
			tx.commit();
		}
		return user;
	}

	@Override
	public int deleteUser(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(User user) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.update(user);
			tx.commit();
		}
	}

}
