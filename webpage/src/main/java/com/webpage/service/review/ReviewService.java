package com.webpage.service.review;

import java.util.List;
import java.util.Map;

import com.webpage.DAO.review.ReviewDTO;

public interface ReviewService {

	List<ReviewDTO> getReview(int itemId, int reviewPageNum);

	void setReview(ReviewDTO review);

	String getWriteReviewBtn(String memberId, int itemId);

	Map<String, Object> getPagingService(int reviewPageNum, int itemId);

	ReviewDTO getReviewContentsViewService(int memberId, int itemId);

	void deleteReviewService(int itemId, String memberId);

}
