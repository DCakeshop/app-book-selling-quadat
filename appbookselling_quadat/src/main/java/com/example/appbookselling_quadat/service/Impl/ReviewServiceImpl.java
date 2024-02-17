package com.example.appbookselling_quadat.service.Impl;

import com.example.appbookselling_quadat.beans.response.ReviewResponse;
import com.example.appbookselling_quadat.entity.Review;
import com.example.appbookselling_quadat.exception.DuplicateException;
import com.example.appbookselling_quadat.exception.NotFoundException;
import com.example.appbookselling_quadat.mapper.ReviewMapper;
import com.example.appbookselling_quadat.repository.ReviewRepository;
import com.example.appbookselling_quadat.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    @Override
    public List<ReviewResponse> getReviewList() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(ReviewMapper::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewResponse getDetailReview(int id) throws NotFoundException {
        Review review = reviewRepository.findReviewById(id);
        if (Objects.isNull(review)){
            throw new NotFoundException("Not Found Objects in Database");
        }
        return ReviewMapper.convertToResponse(review);
    }

    @Override
    public void createReview(Review obj) {
        Review review = reviewRepository.findReviewByComment(obj.getComment());
        if (!Objects.isNull(review)){
            throw new DuplicateException("Comment exist in Database");
        }
        else {
            reviewRepository.save(obj);
        }
    }

    @Override
    public void updateReview(Review obj) {
        Review review = reviewRepository.findReviewByComment(obj.getComment());
        if (!Objects.isNull(review)){
            throw new DuplicateException("Comment exist in Database");
        }
        else {
            reviewRepository.save(obj);
        }
    }

    @Override
    public void delete(int id) {
        Review review = reviewRepository.findReviewById(id);
        if (Objects.isNull(review)){
            throw new NotFoundException("Not Found Objects in Database");
        }
        else {
            reviewRepository.delete(review);
        }
    }
}
