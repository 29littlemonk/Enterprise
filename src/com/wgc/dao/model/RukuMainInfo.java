package com.wgc.dao.model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class RukuMainInfo {
	
	private String id;
	private int productnum;
	private double summoney;
	private String conclusion;
	private String suppliername;
	private Date date;
	private String operator;
	private String jsr;
	private String payment;
	private Set<RuKuDetailInfo> detail = new HashSet<RuKuDetailInfo>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getProductnum() {
		return productnum;
	}
	public void setProductnum(int productnum) {
		this.productnum = productnum;
	}
	public double getSummoney() {
		return summoney;
	}
	public void setSummoney(double summoney) {
		this.summoney = summoney;
	}
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getJsr() {
		return jsr;
	}
	public void setJsr(String jsr) {
		this.jsr = jsr;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public RukuMainInfo() {
		super();
	}
	public RukuMainInfo(String id) {
		super();
		this.id = id;
	}
	public Set<RuKuDetailInfo> getDetail() {
		return detail;
	}
	public void setDetail(Set<RuKuDetailInfo> detail) {
		this.detail = detail;
	}
	public RukuMainInfo(String id, int productnum, double summoney,
			String conclusion, String suppliername, Date date, String operator,
			String jsr, String payment) {
		super();
		this.id = id;
		this.productnum = productnum;
		this.summoney = summoney;
		this.conclusion = conclusion;
		this.suppliername = suppliername;
		this.date = date;
		this.operator = operator;
		this.jsr = jsr;
		this.payment = payment;
	}
	
}
