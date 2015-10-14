package com.wgc.dao.model;

public class RuKuDetailInfo {
	private String rkID;
	private String productID;
	private double price;
	private int count;
	public RuKuDetailInfo() {
		super();
	}
	public RuKuDetailInfo(String rkID, String productID, double price, int count) {
		super();
		this.rkID = rkID;
		this.productID = productID;
		this.price = price;
		this.count = count;
	}
	public String getRkID() {
		return rkID;
	}
	public void setRkID(String rkID) {
		this.rkID = rkID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
