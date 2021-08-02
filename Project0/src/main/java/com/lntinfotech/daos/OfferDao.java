package com.lntinfotech.daos;

import java.util.List;

import com.lntinfotech.models.Offers;

public interface OfferDao {
	public abstract List<Offers> getOffersByVIN (String vin);
	public abstract List<Offers> getOffersByUserId (int userId);
	public abstract int addOffer (Offers offer);
	public abstract List<Offers> getOffersByStatus (String status);
}
