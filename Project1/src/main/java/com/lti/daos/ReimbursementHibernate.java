package com.lti.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementStatus;
import com.lti.models.User;
import com.lti.util.HibernateUtil;



public class ReimbursementHibernate implements ReimbursementDao{

	@Override
	public Reimbursement reimbursementAdded(Reimbursement reimb) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(reimb);
			tx.commit();
		}
		return reimb;
	}

	@Override
	public List<Reimbursement> getReimbursementByUserAndStatus(User user, ReimbursementStatus status) {
		List<Reimbursement> reimbursement = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			String hql = ("From Reimbursement where author = :userId and statId = :stat");
			TypedQuery<Reimbursement> tq = s.createQuery(hql, Reimbursement.class);
			tq.setParameter("userId", user);
			tq.setParameter("stat", status);
			
			reimbursement = tq.getResultList();
		}
		return reimbursement;
		
		
	}

	@Override
	public boolean updateReimbursement(Reimbursement reimb) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			if (s.get(Reimbursement.class, reimb.getReimbId()) == null) {
				return false;
			} else {
				Transaction tx = s.beginTransaction();
				s.merge(reimb);
				tx.commit();

			}
			return true;
		}
		
	}

	@Override
	public List<Reimbursement> getReimbursementByStatus(ReimbursementStatus status) {
		List<Reimbursement> reimbursement = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			String hql = ("From Reimbursement where statId = :stat");
			TypedQuery<Reimbursement> tq = s.createQuery(hql, Reimbursement.class);

			tq.setParameter("stat", status);
			
			reimbursement = tq.getResultList();
		}
		return reimbursement;
		
	}

	@Override
	public List<Reimbursement> getReimbursementByUser(User user) {
		List<Reimbursement> reimbursement = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			String hql = ("From Reimbursement where author = :userId");
			TypedQuery<Reimbursement> tq = s.createQuery(hql, Reimbursement.class);
			tq.setParameter("userId", user);
			
			reimbursement = tq.getResultList();
		}
		return reimbursement;
		
	}

	@Override
	public void deleteReimbursement(Reimbursement reimb) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			s.merge(reimb);
			tx.commit();
		}
		
	}

	@Override
	public Reimbursement getReimbursementById(int reimbId) {
		Reimbursement r = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			r = s.get(Reimbursement.class, reimbId);
		}
		return r;
	}

	@Override
	public List<Reimbursement> getAllReimbursement() {
		List<Reimbursement> reimbs = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			reimbs = s.createQuery("FROM Reimbursement", Reimbursement.class).getResultList();
		}
		return reimbs;
	}

}
