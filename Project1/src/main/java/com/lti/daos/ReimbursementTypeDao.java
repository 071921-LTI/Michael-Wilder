package com.lti.daos;

import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementType;

public interface ReimbursementTypeDao {

	ReimbursementType addType(ReimbursementType type);
	ReimbursementType getReimbursementTypeById(int typeId);

}
