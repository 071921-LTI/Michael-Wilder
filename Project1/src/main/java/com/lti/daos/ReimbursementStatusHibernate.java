package com.lti.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementStatus;
import com.lti.util.HibernateUtil;

public class ReimbursementStatusHibernate implements ReimbursementStatusDao{

	@Override
	public ReimbursementStatus addStatus(ReimbursementStatus status) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(status);
			tx.commit();
		}
		return status;
	}

	@Override
	public void updateStatus(ReimbursementStatus status) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.update(status);
			tx.commit();
		}
		
	}

	@Override
	public ReimbursementStatus getReimbursementStatusById(int statId) {
		ReimbursementStatus r = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			r = s.get(ReimbursementStatus.class, statId);
		}
		return r;
	}


}
