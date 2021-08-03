package com.webpage.service.member;

import java.util.Map;

import com.webpage.DAO.member.MemberDTO;

public interface MemberService {

	public void setMember(MemberDTO memberDTO);
	public boolean getMember(Map<String, Object> map);
}
