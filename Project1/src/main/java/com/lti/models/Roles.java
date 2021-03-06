package com.lti.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Roles {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false)
	private int roleId;
	@Column(name = "user_role", nullable = false)
	private String userRole;
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Roles(String userRole) {
		super();
		this.userRole = userRole;
	}

	public Roles(int roleId) {
		super();
		this.roleId = roleId;
	}

	public Roles(int roleId, String userRole) {
		super();
		this.roleId = roleId;
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", " + (userRole != null ? "userRole=" + userRole : "") + "]";
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + roleId;
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roles other = (Roles) obj;
		if (roleId != other.roleId)
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}
	
	
	
}
