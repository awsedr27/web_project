package com.webpage.service.member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webpage.DAO.member.MemberDAO;
import com.webpage.DAO.member.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberDAO;

	@Override
	public void setMember(MemberDTO memberDTO) {
		
		memberDAO.setMember(memberDTO);
	}

	@Override
	public boolean getMember(Map<String, Object> map) {
		boolean signIn=memberDAO.getMember(map);
		return signIn;
	}

	

	

}
