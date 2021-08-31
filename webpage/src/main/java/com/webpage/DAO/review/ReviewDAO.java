package com.webpage.DAO.review;

import java.util.List;

public interface ReviewDAO {

	List<ReviewDTO> getReview(int itemId);

	void setReview(ReviewDTO review);

	String getWriteReviewBtn(String memberId, int itemId);

	

}
