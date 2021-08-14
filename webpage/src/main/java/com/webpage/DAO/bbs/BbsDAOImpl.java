package com.webpage.DAO.bbs;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BbsDAOImpl implements BbsDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BbsDTO> getBbs(int pageNum) {
		int bbsNum=(pageNum-1)*5;
		List<BbsDTO> list=sqlSession.selectList("mapper.getBbs",bbsNum);
		
		return list;
	}

	@Override
	public int getPageCnt() {
		int pageCnt=sqlSession.selectOne("mapper.getPageCnt");
		pageCnt=(int) Math.ceil(pageCnt/5);
		return pageCnt;
	}

	@Override
	public void setBbs(BbsDTO bbsDTO) {
		sqlSession.insert("mapper.setBbs", bbsDTO);
		
	}

}



