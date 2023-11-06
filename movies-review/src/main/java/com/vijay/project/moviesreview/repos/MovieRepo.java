package com.vijay.project.moviesreview.repos;

import com.vijay.project.moviesreview.models.Movies;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface MovieRepo extends MongoRepository<Movies, ObjectId> {

    Optional<Movies> findByImdbId(String imdbId);
}
