package com.lti.daos;

import java.util.List;

import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementStatus;
import com.lti.models.User;

public interface ReimbursementDao {

	Reimbursement reimbursementAdded(Reimbursement reimb);
	List<Reimbursement> getReimbursementByUserAndStatus(User user, ReimbursementStatus status);
	List<Reimbursement> getReimbursementByUserAndStatus2(User user, ReimbursementStatus status, ReimbursementStatus status1);
	boolean updateReimbursement(Reimbursement reimb);
	List<Reimbursement> getAllReimbursement();
	List<Reimbursement> getReimbursementByStatus(ReimbursementStatus status);
	List<Reimbursement> getReimbursementByStatus2(ReimbursementStatus status, ReimbursementStatus status1);
	List<Reimbursement> getReimbursementByUser(User user);
	void deleteReimbursement(Reimbursement reimb);
	Reimbursement getReimbursementById(int reimbId);
	
}
