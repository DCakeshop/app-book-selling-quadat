package com.example.appbookselling_quadat.controller;

import com.example.appbookselling_quadat.beans.response.ReviewResponse;
import com.example.appbookselling_quadat.entity.Review;
import com.example.appbookselling_quadat.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
@AllArgsConstructor
public class ReviewController {
    private ReviewService reviewService;

    @GetMapping("/all")
    public List<ReviewResponse> getAllReview(){
        return reviewService.getReviewList();
    }

    @GetMapping("/{id}")
    public ReviewResponse getDetailReview(@PathVariable int id){
        return reviewService.getDetailReview(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Review review){
        reviewService.createReview(review);
    }

    @PutMapping("/edit")
    public void update(@RequestBody Review review){
        reviewService.updateReview(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        reviewService.delete(id);
    }
}
