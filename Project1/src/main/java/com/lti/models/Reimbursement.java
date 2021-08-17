package com.lti.models;

import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Column(name = "reimb_amount", nullable = false)
	private double reimbAmount;
	@Column(name = "reimb_sub", nullable = false)
	private Timestamp reimbSub;
	@Column(name = "reimb_res")
	private Timestamp reimbRes;
	@Column(name = "reimb_des")
	private String reimnbDes;
	@Column(name = "receipt")
	private byte[] reciept;
	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "author", nullable = false)
	private User author;
	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "resolver")
	private User resolver;
	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "stat_id", nullable = false)
	private ReimbursementStatus statId;
	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name="type_id", nullable = false)
	private ReimbursementType typeId;
	
	
	public String getReimnbDes() {
		return reimnbDes;
	}
	public void setReimnbDes(String reimnbDes) {
		this.reimnbDes = reimnbDes;
	}
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
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
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
	public Reimbursement(int reimbId, double reimbAmount, Timestamp reimbSub, Timestamp reimbRes, byte[] reciept, User author,
			User resolver, ReimbursementStatus statId, ReimbursementType typeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSub = reimbSub;
		this.reimbRes = reimbRes;
		this.reciept = reciept;
		this.author = author;
		this.resolver = resolver;
		this.statId = statId;
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", "
				+ (reimbSub != null ? "reimbSub=" + reimbSub + ", " : "")
				+ (reimbRes != null ? "reimbRes=" + reimbRes + ", " : "")
				+ (reimnbDes != null ? "reimnbDes=" + reimnbDes + ", " : "")
				+ (reciept != null ? "reciept=" + Arrays.toString(reciept) + ", " : "")
				+ (author != null ? "author=" + author + ", " : "")
				+ (resolver != null ? "resolver=" + resolver + ", " : "")
				+ (statId != null ? "statId=" + statId + ", " : "") + (typeId != null ? "typeId=" + typeId : "") + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + Arrays.hashCode(reciept);
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbId;
		result = prime * result + ((reimbRes == null) ? 0 : reimbRes.hashCode());
		result = prime * result + ((reimbSub == null) ? 0 : reimbSub.hashCode());
		result = prime * result + ((reimnbDes == null) ? 0 : reimnbDes.hashCode());
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
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (!Arrays.equals(reciept, other.reciept))
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
		if (reimnbDes == null) {
			if (other.reimnbDes != null)
				return false;
		} else if (!reimnbDes.equals(other.reimnbDes))
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
	public Reimbursement(int reimbId, double reimbAmount, Timestamp reimbSub, Timestamp reimbRes, User author,
			User resolver, ReimbursementStatus statId, ReimbursementType typeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSub = reimbSub;
		this.reimbRes = reimbRes;
		this.author = author;
		this.resolver = resolver;
		this.statId = statId;
		this.typeId = typeId;
	}
	public Reimbursement(int reimbId, double reimbAmount, Timestamp reimbSub, Timestamp reimbRes, User author,
			ReimbursementStatus statId, ReimbursementType typeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSub = reimbSub;
		this.reimbRes = reimbRes;
		this.author = author;
		this.statId = statId;
		this.typeId = typeId;
	}
	public Reimbursement(int reimbId, double reimbAmount, User author, User resolver, ReimbursementType typeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.author = author;
		this.resolver = resolver;
		this.typeId = typeId;
	}
	public Reimbursement(double reimbAmount, User author, ReimbursementStatus statId, ReimbursementType typeId) {
		super();
		this.reimbAmount = reimbAmount;
		this.author = author;
		this.statId = statId;
		this.typeId = typeId;
	}
	public Reimbursement(double reimbAmount) {
		super();
		this.reimbAmount = reimbAmount;
	}
	public Reimbursement(int reimbId, double reimbAmount) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
	}
	public Reimbursement(int reimbId, Timestamp reimbRes, User resolver, ReimbursementStatus statId) {
		super();
		this.reimbId = reimbId;
		this.reimbRes = reimbRes;
		this.resolver = resolver;
		this.statId = statId;
	}
	public Reimbursement(double reimbAmount, Timestamp reimbSub, User author, ReimbursementStatus statId,
			ReimbursementType typeId) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSub = reimbSub;
		this.author = author;
		this.statId = statId;
		this.typeId = typeId;
	}
	public Reimbursement(int reimbId, double reimbAmount, User author, ReimbursementStatus statId,
			ReimbursementType typeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.author = author;
		this.statId = statId;
		this.typeId = typeId;
	}
	public Reimbursement(int reimbId, double reimbAmount, Timestamp reimbSub, User author, ReimbursementStatus statId,
			ReimbursementType typeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSub = reimbSub;
		this.author = author;
		this.statId = statId;
		this.typeId = typeId;
	}
	public Reimbursement(int reimbId, double reimbAmount, Timestamp reimbSub, Timestamp reimbRes, String reimnbDes,
			byte[] reciept, User author, User resolver, ReimbursementStatus statId, ReimbursementType typeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSub = reimbSub;
		this.reimbRes = reimbRes;
		this.reimnbDes = reimnbDes;
		this.reciept = reciept;
		this.author = author;
		this.resolver = resolver;
		this.statId = statId;
		this.typeId = typeId;
	}
	public Reimbursement(int reimbId, double reimbAmount, Timestamp reimbSub, String reimnbDes, User author,
			ReimbursementStatus statId, ReimbursementType typeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSub = reimbSub;
		this.reimnbDes = reimnbDes;
		this.author = author;
		this.statId = statId;
		this.typeId = typeId;
	}
	
}
