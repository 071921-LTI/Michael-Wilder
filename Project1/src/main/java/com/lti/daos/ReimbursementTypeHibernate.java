package com.lti.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lti.models.ReimbursementType;
import com.lti.util.HibernateUtil;

public class ReimbursementTypeHibernate implements ReimbursementTypeDao{

	@Override
	public ReimbursementType addType(ReimbursementType type) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(type);
			tx.commit();
		}
		return type;
	}

}
