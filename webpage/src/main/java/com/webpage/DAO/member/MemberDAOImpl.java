package com.webpage.DAO.member;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void setMember(MemberDTO memberDTO) {
		
		sqlSession.insert("mapper.setMember",memberDTO);
	}

	@Override
	public boolean getMember(Map<String, Object> map) {
		
		String userID=sqlSession.selectOne("mapper.getMember",map);
		if(userID==null) {
			
			return false;
		}
		else {
			
			return true;
		}
		
	}

	@Override
	public MemberDTO getMemberInfo(String memberId) {
		MemberDTO memberDTO=sqlSession.selectOne("mapper.getMemberInfo", memberId);
		return memberDTO;
	}

	@Override
	public void setMyInfoModify(MemberDTO memberDTO) {
		sqlSession.update("mapper.setMyInfoModify", memberDTO);
		
	}

	@Override
	public boolean checkPassword(String memberId,int memberPassword) {
		int checkPassword=sqlSession.selectOne("mapper.checkPassword", memberId);
		if(memberPassword==checkPassword) {
			return true;
		}else {
			return false;
		}
		
		
	}

	@Override
	public void setNewPassword(String memberId, int newPassword) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("newPassword", newPassword);
		
		sqlSession.update("mapper.setNewPassword", map);
		
	}

	

}
