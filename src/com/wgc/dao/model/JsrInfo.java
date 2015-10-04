package com.wgc.dao.model;

public class JsrInfo {
	private String name;
	private String age;
	private String sex;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public JsrInfo() {
		super();
	}
	public JsrInfo(String name, String age, String sex, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
