package com.webpage.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webpage.DAO.review.ReviewDAO;
import com.webpage.DAO.review.ReviewDTO;

@Service
public class ReviewSerivceImpl implements ReviewService {

	
	@Autowired
	ReviewDAO reviewDAO;
	
	
	@Override
	public List<ReviewDTO> getReview(int itemId) {
		List<ReviewDTO> review=reviewDAO.getReview(itemId);
		return review;
	}

}
