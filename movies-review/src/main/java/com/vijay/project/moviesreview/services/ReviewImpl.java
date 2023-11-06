package com.vijay.project.moviesreview.services;

import com.mongodb.client.result.UpdateResult;
import com.vijay.project.moviesreview.models.Movies;
import com.vijay.project.moviesreview.models.Reviews;
import com.vijay.project.moviesreview.repos.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewImpl implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Reviews saveReview(String review, String imdbId) {
        try {
            Reviews reviews = new Reviews(review); // Create Reviews object with review text
            reviews = reviewRepo.insert(reviews); // Save the review

            // Update the movie's reviewIds with the newly added review
            UpdateResult updateResult = mongoTemplate.update(Movies.class)
                    .matching(Criteria.where("imdbId").is(imdbId))
                    .apply(new Update().push("reviewIds").value(reviews))
                    .first();

            if (updateResult.getModifiedCount() > 0) {
                return reviews;
            } else {
                return null; // Movie with the given imdbId not found
            }
        } catch (Exception e) {
            return null; // Handle exceptions
        }
    }




//    @Override
//    public Reviews saveReview(String review, String imdbId) {
//        Reviews reviews = reviewRepo.insert(new Reviews(review));
//        mongoTemplate.update(Movies.class)
//                .matching(Criteria.where("imdbId").is(imdbId))
//                .apply(new Update().push("reviewIds").value(reviews))
//                .first();
//        return reviews;
//    }
}
