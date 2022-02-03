package com.webpage.DAO.review;

import java.util.List;

public interface ReviewDAO {

	List<ReviewDTO> getReview(int itemId, int reviewPageNum);

	void setReview(ReviewDTO review);

	String getWriteReviewBtn(String memberId, int itemId);

	int getPageCnt(int itemId);

	ReviewDTO getReviewContentsView(String memberId, int itemId);

	void deleteReviewDAO(int itemId, String memberId);

	

}
