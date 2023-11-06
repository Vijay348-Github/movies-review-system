package com.vijay.project.moviesreview.services;

import com.vijay.project.moviesreview.models.Reviews;

public interface ReviewService {
    Reviews saveReview(String review, String imdbId);
}
