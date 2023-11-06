package com.vijay.project.moviesreview.services;

import com.vijay.project.moviesreview.models.Movies;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;


public interface MovieService {

    List<Movies> getAllMovies();
    Optional<Movies> getMovie(ObjectId id);
    Optional<Movies> getMovieNyImdbId(String id);

}
