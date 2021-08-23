package com.webpage.DAO.bbs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BbsDAOImpl implements BbsDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BbsDTO> getBbs(int pageNum) {
		int bbsNum=(pageNum-1)*10;
		List<BbsDTO> list=sqlSession.selectList("mapper.getBbs",bbsNum);
		
		return list;
	}

	@Override
	public int getPageCnt() {
		int pageCnt=sqlSession.selectOne("mapper.getPageCnt");
		
		pageCnt=(int)Math.ceil(pageCnt/10.0);
		
		return pageCnt;
	}

	@Override
	public void setBbs(BbsDTO bbsDTO) {
		sqlSession.insert("mapper.setBbs", bbsDTO);
		
	}

	@Override
	public BbsDTO getBbsView(int bbsId) {
		BbsDTO bbs=sqlSession.selectOne("mapper.getBbsView", bbsId);
		return bbs;
	}

	@Override
	public void setBbsModify(String bbsTitle, String bbsContents,int bbsId) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("bbsTitle", bbsTitle);
		map.put("bbsContents", bbsContents);
		map.put("bbsId", bbsId);

		sqlSession.update("mapper.setBbsModify", map);
		
	}

	@Override
	public void deleteBbs(int bbsId) {
		sqlSession.delete("mapper.deleteBbs", bbsId);
		
	}

}



