package com.lti.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursementStatus")
public class ReimbursementStatus {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "stat_id")
	private int statId;
	private String status;
	
	public int getStatusId() {
		return statId;
	}
	public void setStatusId(int statusId) {
		this.statId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ReimbursementStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbursementStatus(int statusId, String status) {
		super();
		this.statId = statusId;
		this.status = status;
	}
	public ReimbursementStatus(int statusId) {
		super();
		this.statId = statusId;
	}
	
	public ReimbursementStatus(String status) {
		super();
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReimburstmentStatus [statusId=" + statId + ", " + (status != null ? "status=" + status : "") + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + statId;
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
		ReimbursementStatus other = (ReimbursementStatus) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statId != other.statId)
			return false;
		return true;
	}
	
	
}
