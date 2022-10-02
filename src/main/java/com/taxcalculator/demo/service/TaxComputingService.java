package com.taxcalculator.demo.service;

import java.util.List;

import com.taxcalculator.demo.model.Share;
import com.taxcalculator.demo.model.Trade;

public interface TaxComputingService {

	// Add share entity
	public int addShare(Share share);

	// Get All share details
	public List<Share> getShareDetails();

	// Add Trade
	public Trade addTrade(int shareId, int quantity);

	// Get All Trade details
	public List<Trade> getTradeDetails();

	// Get Trade by ID
	public Trade getTradebyId(int tradeId);

}
