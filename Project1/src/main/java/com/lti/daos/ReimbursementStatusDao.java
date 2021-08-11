package com.lti.daos;

import com.lti.models.ReimbursementStatus;

public interface ReimbursementStatusDao {

	ReimbursementStatus addStatus (ReimbursementStatus status);
	void updateStatus (ReimbursementStatus status);
}
