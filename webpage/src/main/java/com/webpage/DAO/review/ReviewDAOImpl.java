package com.webpage.DAO.review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webpage.DAO.item.ItemDTO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ReviewDTO> getReview(int itemId) {
		
		List<ReviewDTO> review=sqlSession.selectList("mapper.getReview", itemId);
		return review;
		
		
	}

}
