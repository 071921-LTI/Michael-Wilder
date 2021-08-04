package com.lntinfotech.daos;

import java.util.List;

import com.lntinfotech.models.Offers;
import com.lntinfotech.models.Vehicles;

public interface OfferDao {
	public abstract List<Offers> getOffersByVIN (String vin);
	public abstract List<Offers> getOffersByUserId (int userId);
	public abstract int addOffer (Offers offer);
	public abstract List<Offers> getOffersByStatus (String status);
	public abstract boolean acceptOffer (Offers offer, Vehicles vehicle);
	public abstract Offers getOfferById (int id);
	public abstract double offerAmount (int id);
	public abstract int userId (int id);
	public abstract String vinById(int id);
	public abstract boolean rejectOffer(String vin, double offer);
	public abstract boolean rejectOfferById(int id);
	public abstract List<Offers> getAllOffers ();
}
