package com.vijay.project.moviesreview.repos;

import com.vijay.project.moviesreview.models.Reviews;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends MongoRepository<Reviews, ObjectId> {

}
