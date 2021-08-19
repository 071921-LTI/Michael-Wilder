package com.lti.services;

import java.util.List;

import com.lti.daos.ReimbursementDao;
import com.lti.daos.ReimbursementHibernate;
import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementStatus;
import com.lti.models.User;

public class ReimbursementServiceImpl implements ReimbursementService{

	ReimbursementDao rd = new ReimbursementHibernate();

	@Override
	public boolean reimbursementAdded(Reimbursement reimb) {
		if (rd.reimbursementAdded(reimb) != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Reimbursement> getReimbursementByUserAndStatus(User user, ReimbursementStatus status) {
		return rd.getReimbursementByUserAndStatus(user, status);
	}

	@Override
	public boolean updateReimbursement(Reimbursement reimb) {
		return rd.updateReimbursement(reimb);
	}

	@Override
	public List<Reimbursement> getReimbursementByStatus(ReimbursementStatus status) {
		return rd.getReimbursementByStatus(status);
	}

	@Override
	public List<Reimbursement> getReimbursementByUser(User user) {
		return rd.getReimbursementByUser(user);
	}

	@Override
	public void deleteReimbursement(Reimbursement reimb) {
		rd.deleteReimbursement(reimb);
		
	}

	@Override
	public List<Reimbursement> getAllReimbursement() {
		return rd.getAllReimbursement();
	}

	@Override
	public Reimbursement getReimbursementById(int reimbId) {
		return rd.getReimbursementById(reimbId);
	}

	@Override
	public List<Reimbursement> getReimbursementByUserAndStatus2(User user, ReimbursementStatus status,
			ReimbursementStatus status1) {
		return rd.getReimbursementByUserAndStatus2(user, status, status1);
	}

	@Override
	public List<Reimbursement> getReimbursementByStatus2(ReimbursementStatus status, ReimbursementStatus status1) {
		return rd.getReimbursementByStatus2(status, status1);
	}

}
