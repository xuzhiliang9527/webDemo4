package com.woniuxy.DAO.PO;

import java.io.Serializable;

/*
 * teacher的信息存储类
 */
public class TeacherPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private String age;
	private String sex;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public  TeacherPO(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public  TeacherPO(String name, String password, String age, String sex,String address) {
		this.name = name;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.address = address;
	}
	
}
