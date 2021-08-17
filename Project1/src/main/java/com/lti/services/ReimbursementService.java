package com.lti.services;

import java.util.List;

import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementStatus;
import com.lti.models.User;

public interface ReimbursementService {
	boolean reimbursementAdded(Reimbursement reimb);
	List<Reimbursement> getReimbursementByUserAndStatus(User user, ReimbursementStatus status);
	boolean updateReimbursement(Reimbursement reimb);
	List<Reimbursement> getReimbursementByStatus(ReimbursementStatus status);
	List<Reimbursement> getReimbursementByUser(User user);
	void deleteReimbursement(Reimbursement reimb);
	List<Reimbursement> getAllReimbursement();
	Reimbursement getReimbursementById(int reimbId);
}
