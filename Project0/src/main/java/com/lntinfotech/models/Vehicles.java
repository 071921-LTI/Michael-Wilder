package com.lntinfotech.models;

import java.sql.Date;

public class Vehicles {
	private String vin;
	private Date year;
	private String make;
	private String model;
	private double price;

	
	
	
	@Override
	public String toString() {
		return "Vehicles [vin=" + vin + ", year=" + year + ", make=" + make + ", model=" + model + ", price=" + price
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		Vehicles other = (Vehicles) obj;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	public Vehicles(String vin) {
		super();
		this.vin = vin;
	}
	public Vehicles(Date year, String make, String model) {
		super();
		this.year = year;
		this.make = make;
		this.model = model;
	}
	public Vehicles(String vin, Date year, String make, String model, double price) {
		super();
		this.vin = vin;
		this.year = year;
		this.make = make;
		this.model = model;
		this.price = price;

	}
	public Vehicles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
