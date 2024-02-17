package com.example.appbookselling_quadat.mapper;

import com.example.appbookselling_quadat.beans.response.ReviewResponse;
import com.example.appbookselling_quadat.entity.Review;

public class ReviewMapper {
    public static ReviewResponse convertToResponse(Review review){
        ReviewResponse reviewResponse = new ReviewResponse();
        reviewResponse.setBookId(review.getBookId());
        reviewResponse.setCustomerId(review.getCustomerId());
        reviewResponse.setRating(review.getRating());
        reviewResponse.setComment(review.getComment());
        return reviewResponse;
    }
}
