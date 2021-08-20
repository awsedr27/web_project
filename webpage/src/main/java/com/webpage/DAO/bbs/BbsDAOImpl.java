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
	public BbsDTO getBbsView(int bbs_id) {
		BbsDTO bbs=sqlSession.selectOne("mapper.getBbsView", bbs_id);
		return bbs;
	}

	@Override
	public void setBbsModify(String bbs_title, String bbs_contents,int bbs_id) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("bbs_title", bbs_title);
		map.put("bbs_contents", bbs_contents);
		map.put("bbs_id", bbs_id);

		sqlSession.update("mapper.setBbsModify", map);
		
	}

	@Override
	public void deleteBbs(int bbs_id) {
		sqlSession.delete("mapper.deleteBbs", bbs_id);
		
	}

}



