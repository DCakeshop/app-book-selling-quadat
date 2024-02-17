package com.example.appbookselling_quadat.repository;

import com.example.appbookselling_quadat.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Review findReviewById(int id);
    Review findReviewByComment(String comment);
}
