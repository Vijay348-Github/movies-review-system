package com.vijay.project.moviesreview.controllers;

import com.vijay.project.moviesreview.models.Reviews;
import com.vijay.project.moviesreview.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
//            new Reviews(payLoad.get("reviewBody"), payLoad.get("imdbId"))
    @PostMapping
    public ResponseEntity<Reviews> saveReview(@RequestBody Map<String, String> payLoad){

//        Reviews reviews = reviewService.saveReview(payLoad.get("reviewBody"),payLoad.get("imdbId"));
//        return ResponseEntity.ok(reviews);

        try {
            String reviewBody = payLoad.get("reviewBody");
            String imdbId = payLoad.get("imdbId");

            if (reviewBody == null || imdbId == null) {
                return ResponseEntity.badRequest().body(null); // Handle missing data
            }
            Reviews reviews = reviewService.saveReview(reviewBody, imdbId);
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Handle exceptions
        }
    }
}
