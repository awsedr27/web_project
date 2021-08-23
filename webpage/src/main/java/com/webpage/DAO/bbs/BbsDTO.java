package com.webpage.DAO.bbs;

import java.sql.Date;

public class BbsDTO {
	
	private String memberId;
	private int bbsId;
	private String bbsTitle;
	private Date bbsTime;
	private String bbsContents;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getBbsId() {
		return bbsId;
	}
	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public Date getBbsTime() {
		return bbsTime;
	}
	public void setBbsTime(Date bbsTime) {
		this.bbsTime = bbsTime;
	}
	public String getBbsContents() {
		return bbsContents;
	}
	public void setBbsContents(String bbsContents) {
		this.bbsContents = bbsContents;
	}
	
	
	

}
