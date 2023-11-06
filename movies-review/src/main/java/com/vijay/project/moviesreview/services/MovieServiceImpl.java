package com.vijay.project.moviesreview.services;

import com.vijay.project.moviesreview.models.Movies;
import com.vijay.project.moviesreview.repos.MovieRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepo movieRepo;

    @Override
    public List<Movies> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public Optional<Movies> getMovie(ObjectId id) {
        return movieRepo.findById(id);
    }

    @Override
    public Optional<Movies> getMovieNyImdbId(String id) {
        return movieRepo.findByImdbId(id);
    }


}

