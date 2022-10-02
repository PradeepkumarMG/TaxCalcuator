package com.taxcalculator.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "share_details")
public class Share {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shareId;
	@Column(unique = true)
	private String shareName;
	private double sharePrice;
	private float taxRate;

	public int getShareId() {
		return shareId;
	}

	public void setShareId(int shareId) {
		this.shareId = shareId;
	}

	public String getShareName() {
		return shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	public float getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}
	
	public Share(int shareId, String shareName, double sharePrice, float taxRate) {
		super();
		this.shareId = shareId;
		this.shareName = shareName;
		this.sharePrice = sharePrice;
		this.taxRate = taxRate;
	}

	public Share() {
	}

	

}
