package com.webpage.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webpage.DAO.orderItem.OrderItemDAO;
import com.webpage.DAO.review.ReviewDAO;
import com.webpage.DAO.review.ReviewDTO;

@Service
public class ReviewSerivceImpl implements ReviewService {

	
	@Autowired
	ReviewDAO reviewDAO;
	
	@Autowired
	OrderItemDAO orderItemDAO;
	
	
	@Override
	public List<ReviewDTO> getReview(int itemId) {
		List<ReviewDTO> review=reviewDAO.getReview(itemId);
		return review;
	}


	@Override
	public void setReview(ReviewDTO review) {
		reviewDAO.setReview(review);
		
	}


	@Transactional
	@Override
	public String getWriteReviewBtn(String memberId,int itemId) {
		String isPurchase=orderItemDAO.isPurchase(memberId,itemId);
		if(isPurchase.equals("NotPurchase")) {
			return "NotPurchase";
		}else {
			String writeReviewBtn=reviewDAO.getWriteReviewBtn(memberId,itemId);
			return writeReviewBtn;
			
		}
		
	}

}
