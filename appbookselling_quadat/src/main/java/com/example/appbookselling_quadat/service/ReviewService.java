package com.example.appbookselling_quadat.service;

import com.example.appbookselling_quadat.beans.response.ReviewResponse;
import com.example.appbookselling_quadat.entity.Review;
import com.example.appbookselling_quadat.exception.NotFoundException;

import java.util.List;

public interface ReviewService {
    List<ReviewResponse> getReviewList();
    ReviewResponse getDetailReview(int id) throws NotFoundException;
    void createReview(Review obj);
    void updateReview(Review obj);
    void delete(int id);
}
