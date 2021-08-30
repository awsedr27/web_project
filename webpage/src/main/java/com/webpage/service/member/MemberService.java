package com.webpage.service.member;

import java.util.List;
import java.util.Map;

import com.webpage.DAO.member.MemberDTO;
import com.webpage.DAO.orderInfo.OrderInfoDTO;
import com.webpage.DAO.orderItem.OrderItemDTO;

public interface MemberService {

	public void setMember(MemberDTO memberDTO);
	public boolean getMember(Map<String, Object> map);
	public MemberDTO getMemberInfo(String memberId);
	public void setMyInfoModify(MemberDTO memberDTO);
	public boolean checkPassword(String userId, int memberPassword);
	public void setNewPassword(String userId, int newPassword);
	public List<OrderInfoDTO> getMemberOrderService(String memberId);
}
