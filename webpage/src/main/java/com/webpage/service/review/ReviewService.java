package com.webpage.service.review;

import java.util.List;

import com.webpage.DAO.review.ReviewDTO;

public interface ReviewService {

	List<ReviewDTO> getReview(int itemId);

}