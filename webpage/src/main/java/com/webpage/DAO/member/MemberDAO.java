package com.webpage.DAO.member;

import java.util.Map;

public interface MemberDAO {
	public void setMember(MemberDTO memberDTO);
	public boolean getMember(Map<String, Object> map);
	public MemberDTO getMemberInfo(String memberId);
	public void setMyInfoModify(MemberDTO memberDTO);
	public boolean checkPassword(String userId, int memberPassword);
	public void setNewPassword(String userId, int newPassword);

}
