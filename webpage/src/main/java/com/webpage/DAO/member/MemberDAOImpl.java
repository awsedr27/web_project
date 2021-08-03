package com.webpage.DAO.member;

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
			System.out.print(userID);
			return false;
		}
		else {
			System.out.print(userID);
			return true;
		}
		
	}

	

}
