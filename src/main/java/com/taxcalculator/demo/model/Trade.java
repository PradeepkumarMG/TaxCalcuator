package com.taxcalculator.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trade_details")
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tradeId;
	private String shareName;
	private int quantity;
	private double computedTax;
	private double totalPrice;

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getShareName() {
		return shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getComputedTax() {
		return computedTax;
	}

	public void setComputedTax(double computedTax) {
		this.computedTax = computedTax;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Trade() {
	}

	public Trade(int tradeId, String shareName, int quantity, double computedTax, double totalPrice) {
		super();
		this.tradeId = tradeId;
		this.shareName = shareName;
		this.quantity = quantity;
		this.computedTax = computedTax;
		this.totalPrice = totalPrice;
	}


}
