package com.lti.daos;

import java.util.List;

import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementStatus;
import com.lti.models.User;

public interface ReimbursementDao {

	Reimbursement reimbursementAdded(Reimbursement reimb);
	List<Reimbursement> getReimbursementByUserAndStatus(User user, ReimbursementStatus status);
	void updateReimbursement(Reimbursement reimb);
	List<Reimbursement> getReimbursementByStatus(ReimbursementStatus status);
	List<Reimbursement> getReimbursementByUser(User user);
	void deleteReimbursement(Reimbursement reimb);
}
