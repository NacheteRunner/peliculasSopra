package com.movies.services;

import com.movies.model.MovieDTO;
import com.movies.model.MovieResponse;

import java.util.List;

public interface MoviesService {

    public MovieResponse addMovie (MovieDTO movieDTO);
    public List<MovieResponse> readMovies();
    public MovieResponse findMoviesById(int id);
    public List<MovieResponse> findMoviesByName (String title);
    public List<MovieResponse> findMoviesByText (String text);
}
