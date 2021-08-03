package com.webpage.DAO.member;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberDTO {

	private String memberID;
	private int memberPassword;
	private Date birthday;
	private int phoneNum;
	private String email;
	
	
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public int getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(int memberPassword) {
		this.memberPassword = memberPassword;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
