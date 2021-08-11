package com.lti.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lti.models.Roles;
import com.lti.util.HibernateUtil;

public class RolesHibernate implements RolesDao{

	@Override
	public Roles addRole(Roles role) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(role);
			tx.commit();
		}
		return role;
	}

}
