package com.lntinfotech.models;

import java.util.List;

import com.lntinfotech.daos.VehicleDao;
import com.lntinfotech.daos.VehiclePostgres;

public class Vehicles{
	private String vin;
	private int year;
	private String make;
	private String model;
	private double price;
	private boolean offers;
	private double remBal;
	private int lenRem;
	private User userId;
	private Employee emplId;
//	private boolean toString1;
//	private int userId1;
//	private int emplId1;

	
	
//	public boolean isToString1() {
//		return toString1;
//	}
//
//	public void setToString1(boolean toString1) {
//		this.toString1 = toString1;
//	}

	public Vehicles(String vin, int year, String make, String model, double price) {
		super();
		this.vin = vin;
		this.year = year;
		this.make = make;
		this.model = model;
		
	}

	public Vehicles(boolean offers) {
		super();
		this.offers = offers;
	}

	public Vehicles(String make, String model) {
		super();
		this.make = make;
		this.model = model;
	}

	public Vehicles(int year) {
		super();
		this.year = year;
	}

	public Vehicles(String vin) {
		super();
		this.vin = vin;
	}





	public Vehicles(String vin, int year, String make, String model, double price, boolean offers, double remBal,
			int lenRem, User userId, Employee emplId) {
		super();
		this.vin = vin;
		this.year = year;
		this.make = make;
		this.model = model;
		this.price = price;
		this.offers = offers;
		this.remBal = remBal;
		this.lenRem = lenRem;
		this.userId = userId;
		this.emplId = emplId;

	}

	public Vehicles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicles(String vin, int year, String make, String model, double price, boolean offers) {
		super();
		this.vin = vin;
		this.year = year;
		this.make = make;
		this.model = model;
		this.price = price;
		this.offers = offers;
	}



	
	@Override
	public String toString() {
		return "Vehicles " + (vin != null ? "vin = " + vin + " " : "") + "year = " + year + " "
				+ (make != null ? "make = " + make + " " : "") + (model != null ? "model = " + model + " " : "")
				+ "price = " + price + " offers = " + offers + (remBal != 0 ? "remBal = " + remBal + " " : "") + (lenRem != 0 ? "lenRem = " + lenRem + " " : "")
				+ (userId != null ? " userId = " + userId + " " : "") + (emplId != null ? "emplId = " + emplId : "") + "";
	}

	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
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
	public boolean isOffers() {
		return offers;
	}
	public void setOffers(boolean offers) {
		this.offers = offers;
	}
	public double getRemBal() {
		return remBal;
	}
	public void setRemBal(double remBal) {
		this.remBal = remBal;
	}
	public int getLenRem() {
		return lenRem;
	}
	public void setLenRem(int lenRem) {
		this.lenRem = lenRem;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Employee getEmplId() {
		return emplId;
	}
	public void setEmplId(Employee emplId) {
		this.emplId = emplId;
	}



}
