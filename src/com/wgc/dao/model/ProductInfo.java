package com.wgc.dao.model;

public class ProductInfo {
	
	private String id;
	private String fullname;
	private String shortname;
	private String originplace;
	private String unit;
	private String standard;
	private String pac;
	private String lotnumber;
	private String approval;
	private String memo;
	private String supplier;
	public ProductInfo() {
		super();
	}
	public ProductInfo(String id) {
		super();
		this.id = id;
	}
	public ProductInfo(String id, String fullname, String shortname,
			String originplace, String unit, String standard, String pac,
			String lotnumber, String approval, String memo, String supplier) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.shortname = shortname;
		this.originplace = originplace;
		this.unit = unit;
		this.standard = standard;
		this.pac = pac;
		this.lotnumber = lotnumber;
		this.approval = approval;
		this.memo = memo;
		this.supplier = supplier;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getOriginplace() {
		return originplace;
	}
	public void setOriginplace(String originplace) {
		this.originplace = originplace;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getPac() {
		return pac;
	}
	public void setPac(String pac) {
		this.pac = pac;
	}
	public String getLotnumber() {
		return lotnumber;
	}
	public void setLotnumber(String lotnumber) {
		this.lotnumber = lotnumber;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	
}
