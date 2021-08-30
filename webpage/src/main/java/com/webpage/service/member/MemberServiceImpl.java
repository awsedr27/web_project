package com.webpage.service.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webpage.DAO.member.MemberDAO;
import com.webpage.DAO.member.MemberDTO;
import com.webpage.DAO.orderInfo.OrderInfoDAO;
import com.webpage.DAO.orderInfo.OrderInfoDTO;
import com.webpage.DAO.orderItem.OrderItemDAO;
import com.webpage.DAO.orderItem.OrderItemDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
	@Autowired
	OrderInfoDAO orderInfo;
	
	@Autowired
	OrderItemDAO orderItem;

	@Override
	public void setMember(MemberDTO memberDTO) {
		
		memberDAO.setMember(memberDTO);
	}

	@Override
	public boolean getMember(Map<String, Object> map) {
		boolean signIn=memberDAO.getMember(map);
		return signIn;
	}

	@Override
	public MemberDTO getMemberInfo(String memberId) {
		MemberDTO memberDTO=memberDAO.getMemberInfo(memberId);
		return memberDTO;
		
	}

	@Override
	public void setMyInfoModify(MemberDTO memberDTO) {
		memberDAO.setMyInfoModify(memberDTO);
		
	}

	@Override
	public boolean checkPassword(String userId,int memberPassword) {
		boolean passwordCheck=memberDAO.checkPassword(userId,memberPassword);
		return passwordCheck;
	}

	@Override
	public void setNewPassword(String userId, int newPassword) {
		
		memberDAO.setNewPassword(userId,newPassword);
		
	}

	@Transactional
	@Override
	public List<OrderInfoDTO> getMemberOrderService(String memberId) {
		List<OrderInfoDTO> list=orderInfo.getMemberOrderDAO(memberId);
		
		for(int i=0;i<list.size();i++) {
			List<OrderItemDTO> orderItemList=orderItem.getOrderItem(list.get(i).getOrderId());
			list.get(i).setOrderItemList(orderItemList);
			
		}
		return list;
	}
	
	

	

	

}
