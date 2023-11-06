package com.vijay.project.moviesreview.controllers;

import com.vijay.project.moviesreview.models.Movies;
import com.vijay.project.moviesreview.services.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies() {
        List<Movies> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Movies>> getMovie(@PathVariable ObjectId id){
//        Optional<Movies> movie = movieService.getMovie(id);
//        return ResponseEntity.ok(movie);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movies>> getMovieNyIMdbId(@PathVariable String id){
        Optional<Movies> movie = movieService.getMovieNyImdbId(id);
        return ResponseEntity.ok(movie);
    }
}
