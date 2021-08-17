package com.lti.daos;

import com.lti.models.ReimbursementStatus;
import com.lti.models.Roles;


public interface RolesDao {
	Roles addRole(Roles role);
	Roles getRoleById(int roleId);
}
