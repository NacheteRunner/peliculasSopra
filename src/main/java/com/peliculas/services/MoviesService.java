package com.peliculas.services;

import com.peliculas.model.MovieDTO;
import com.peliculas.model.MovieResponse;

import java.util.List;

public interface MoviesService {

    public MovieResponse addMovie (MovieDTO movieDTO);
    public List<MovieResponse> readMovies();
    public MovieResponse findMoviesById(int id);
    public List<MovieResponse> findMoviesByName (String titulo);
    public List<MovieResponse> findMoviesByText (String texto);
}
