package com.lntinfotech.models;

public class Offers {

	private int id;
	private String status;
	private double offer;
	private Vehicles vin;
	private User userId;
	
	
	
	public Offers(String status, Vehicles vin) {
		super();
		this.status = status;
		this.vin = vin;
	}
	public Offers(String status, User userId) {
		super();
		this.status = status;
		this.userId = userId;
	}
	public Offers(Vehicles vin) {
		super();
		this.vin = vin;
	}
	public Offers(User userId) {
		super();
		this.userId = userId;
	}
	public Offers(String status) {
		super();
		this.status = status;
	}
	public Offers(int id) {
		super();
		this.id = id;
	}
	public Offers(int id, String status, double offer, Vehicles vin, User userId) {
		super();
		this.id = id;
		this.status = status;
		this.offer = offer;
		this.vin = vin;
		this.userId = userId;
	}
	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Offers id = " + id + ", " + (status != null ? "status = " + status + ", " : "") + "offer = " + offer + ", "
				+ (vin != null ? "vin = " + vin + ", " : "") + (userId != null ? "userId = " + userId : "") + "";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(offer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
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
		Offers other = (Offers) obj;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(offer) != Double.doubleToLongBits(other.offer))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getOffer() {
		return offer;
	}
	public void setOffer(double offer) {
		this.offer = offer;
	}
	public Vehicles getVin() {
		return vin;
	}
	public void setVin(Vehicles vin) {
		this.vin = vin;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}

	
}
