package com.webpage.service.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<ReviewDTO> getReview(int itemId,int reviewPageNum) {
		List<ReviewDTO> review=reviewDAO.getReview(itemId,reviewPageNum);
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


	@Override
	public Map<String, Object> getPagingService(int reviewPageNum,int itemId) {
		Map<String,Object> map=new HashMap<String,Object>();
		int pageCnt=reviewDAO.getPageCnt(itemId);
		
		int pageRangeFirst=0;
		int pageRangeLast=0;
		boolean nextRange;
		if(pageCnt==0) {
			pageCnt++;
		}
		if(reviewPageNum%10==0) {
			--reviewPageNum;
			 pageRangeFirst= (10*((int)Math.floor(reviewPageNum/10.0)))+1;
			 ++reviewPageNum;
			 pageRangeLast=pageRangeFirst+9;
			
		}else {
			 pageRangeFirst= (10*((int)Math.floor(reviewPageNum/10.0)))+1;
			 pageRangeLast=pageRangeFirst+9;
		}
		
		if(pageRangeLast<pageCnt) {
			nextRange=true;
			
		}else {
			nextRange=false;
		}
		
		map.put("pageCnt", pageCnt);
		map.put("pageRangeLast", pageRangeLast);
		map.put("pageRangeFirst", pageRangeFirst);
		map.put("nextRange", nextRange);

		return map;
	}


	@Override
	public ReviewDTO getReviewContentsViewService(int memberId, int itemId) {
		ReviewDTO review=reviewDAO.getReviewContentsView(memberId,itemId);
		return review;
	}


	@Override
	public void deleteReviewService(int itemId, String memberId) {
		reviewDAO.deleteReviewDAO(itemId,memberId);
		
	}

}
