package com.webpage.DAO.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webpage.DAO.item.ItemDTO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ReviewDTO> getReview(int itemId,int reviewPageNum) {
		int reviewNum=(reviewPageNum-1)*15;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("reviewPageNum", reviewNum);
		map.put("itemId", itemId);
		
		List<ReviewDTO> review=sqlSession.selectList("mapper.getReview", map);
		return review;
		
		
	}

	@Override
	public void setReview(ReviewDTO review) {
		sqlSession.insert("mapper.setReview", review);
		
	}

	@Override
	public String getWriteReviewBtn(String memberId,int itemId) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("itemId", itemId);
		
		ReviewDTO writeReviewBtn=sqlSession.selectOne("mapper.getWriteReviewBtn", map);
		
		if(writeReviewBtn==null) {
			return "true";
			
		}else {
			return "false";
		}
	
	}

	@Override
	public int getPageCnt(int itemId) {
        int pageCnt=sqlSession.selectOne("mapper.getReviewPageCnt",itemId);
		
		pageCnt=(int)Math.ceil(pageCnt/15.0);
		
		return pageCnt;
	}

	
	

}
