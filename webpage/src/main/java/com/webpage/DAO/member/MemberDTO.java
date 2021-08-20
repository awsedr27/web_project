package com.webpage.DAO.member;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberDTO {

	private String memberId;
	private int memberPassword;
	private Date birthday;
	private int phoneNum;
	private String email;
	private String houseLocation;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public String getHouseLocation() {
		return houseLocation;
	}
	public void setHouseLocation(String houseLocation) {
		this.houseLocation = houseLocation;
	}
	
	
	
}
