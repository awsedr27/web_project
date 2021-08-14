package com.webpage.DAO.bbs;

import java.sql.Date;

public class BbsDTO {
	
	private String memberId;
	private int bbs_id;
	private String bbs_title;
	private Date bbs_time;
	private String bbs_contents;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getBbs_id() {
		return bbs_id;
	}
	public void setBbs_id(int bbs_id) {
		this.bbs_id = bbs_id;
	}
	public String getBbs_title() {
		return bbs_title;
	}
	public void setBbs_title(String bbs_title) {
		this.bbs_title = bbs_title;
	}
	public Date getBbs_time() {
		return bbs_time;
	}
	public void setBbs_time(Date bbs_time) {
		this.bbs_time = bbs_time;
	}
	public String getBbs_contents() {
		return bbs_contents;
	}
	public void setBbs_contents(String bbs_contents) {
		this.bbs_contents = bbs_contents;
	}
	
	

}
