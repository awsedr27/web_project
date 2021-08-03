package com.webpage.DAO.member;

import java.util.Map;

public interface MemberDAO {
	public void setMember(MemberDTO memberDTO);
	public boolean getMember(Map<String, Object> map);

}
