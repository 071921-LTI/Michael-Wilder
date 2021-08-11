package com.lti.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "reimbursement")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "reimb_id")
	private int reimbId;
	private double reimbAmount;
	private Timestamp reimbSub;
	private Timestamp reimbRes;
	private byte[] reciept;
	@OneToOne @JoinColumn(name="author")

	private User auther;
	@OneToOne @JoinColumn(name="resolver")
	private User resolver;
	@OneToOne @JoinColumn(name="stat_id")

	private ReimbursementStatus statId;
	@OneToOne @JoinColumn(name="type_id")
	private ReimbursementType typeId;
	
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public Timestamp getReimbSub() {
		return reimbSub;
	}
	public void setReimbSub(Timestamp reimbSub) {
		this.reimbSub = reimbSub;
	}
	public Timestamp getReimbRes() {
		return reimbRes;
	}
	public void setReimbRes(Timestamp reimbRes) {
		this.reimbRes = reimbRes;
	}
	public byte[] getReciept() {
		return reciept;
	}
	public void setReciept(byte[] reciept) {
		this.reciept = reciept;
	}
	public User getAuther() {
		return auther;
	}
	public void setAuther(User auther) {
		this.auther = auther;
	}
	public User getResolver() {
		return resolver;
	}
	public void setResolver(User resolver) {
		this.resolver = resolver;
	}
	public ReimbursementStatus getStatId() {
		return statId;
	}
	public void setStatId(ReimbursementStatus statId) {
		this.statId = statId;
	}
	public ReimbursementType getTypeId() {
		return typeId;
	}
	public void setTypeId(ReimbursementType typeId) {
		this.typeId = typeId;
	}
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int reimbId, double reimbAmount, Timestamp reimbSub, Timestamp reimbRes, byte[] reciept, User auther,
			User resolver, ReimbursementStatus statId, ReimbursementType typeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSub = reimbSub;
		this.reimbRes = reimbRes;
		this.reciept = reciept;
		this.auther = auther;
		this.resolver = resolver;
		this.statId = statId;
		this.typeId = typeId;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", "
				+ (reimbSub != null ? "reimbSub=" + reimbSub + ", " : "")
				+ (reimbRes != null ? "reimbRes=" + reimbRes + ", " : "")
				+ (reciept != null ? "reciept=" + reciept + ", " : "")
				+ (auther != null ? "auther=" + auther + ", " : "")
				+ (resolver != null ? "resolver=" + resolver + ", " : "")
				+ (statId != null ? "statId=" + statId + ", " : "") + (typeId != null ? "typeId=" + typeId : "") + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auther == null) ? 0 : auther.hashCode());
		result = prime * result + ((reciept == null) ? 0 : reciept.hashCode());
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbId;
		result = prime * result + ((reimbRes == null) ? 0 : reimbRes.hashCode());
		result = prime * result + ((reimbSub == null) ? 0 : reimbSub.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((statId == null) ? 0 : statId.hashCode());
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (auther == null) {
			if (other.auther != null)
				return false;
		} else if (!auther.equals(other.auther))
			return false;
		if (reciept == null) {
			if (other.reciept != null)
				return false;
		} else if (!reciept.equals(other.reciept))
			return false;
		if (Double.doubleToLongBits(reimbAmount) != Double.doubleToLongBits(other.reimbAmount))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (reimbRes == null) {
			if (other.reimbRes != null)
				return false;
		} else if (!reimbRes.equals(other.reimbRes))
			return false;
		if (reimbSub == null) {
			if (other.reimbSub != null)
				return false;
		} else if (!reimbSub.equals(other.reimbSub))
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (statId == null) {
			if (other.statId != null)
				return false;
		} else if (!statId.equals(other.statId))
			return false;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		return true;
	}
	public Reimbursement(int reimbId, double reimbAmount, Timestamp reimbSub, Timestamp reimbRes, User auther,
			User resolver, ReimbursementStatus statId, ReimbursementType typeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSub = reimbSub;
		this.reimbRes = reimbRes;
		this.auther = auther;
		this.resolver = resolver;
		this.statId = statId;
		this.typeId = typeId;
	}
	public Reimbursement(int reimbId, double reimbAmount, Timestamp reimbSub, Timestamp reimbRes, User auther,
			ReimbursementStatus statId, ReimbursementType typeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSub = reimbSub;
		this.reimbRes = reimbRes;
		this.auther = auther;
		this.statId = statId;
		this.typeId = typeId;
	}
	public Reimbursement(int reimbId, double reimbAmount, User auther, User resolver, ReimbursementType typeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.auther = auther;
		this.resolver = resolver;
		this.typeId = typeId;
	}
	public Reimbursement(double reimbAmount, User auther, ReimbursementStatus statId, ReimbursementType typeId) {
		super();
		this.reimbAmount = reimbAmount;
		this.auther = auther;
		this.statId = statId;
		this.typeId = typeId;
	}
	
}
