package com.movies.services;

import com.movies.model.MovieEntity;
import com.movies.model.MovieResponse;
import com.movies.repository.MoviesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)

class MoviesServiceImplTest {

    @Mock
    private MoviesRepository moviesRepository;

    @InjectMocks
    private MoviesServiceImpl moviesServiceImpl;

    @Test
    void addMovie() {
        // https://www.baeldung.com/mockito-unnecessary-stubbing-exception lenient()
        MovieEntity movie = makeMovie();
        lenient().when(moviesRepository.save(movie)).thenReturn(movie);
        assertEquals(movie,movie);
    }

    @Test
    void readMovies() {
        List<MovieEntity> movieEntities = new ArrayList<>();
        Mockito.when(moviesRepository.findAll()).thenReturn(movieEntities);
        assertInstanceOf(moviesServiceImpl.readMovies().getClass(), movieEntities);
    }
    @Test
    void readMoviesWithoutMovies() {
        List<MovieEntity> moviesEntities = new ArrayList<MovieEntity>();
        List<MovieResponse> moviesResponse = new ArrayList<>();
        MovieResponse movie = new MovieResponse();
        movie.setTitle("Todavia no se ha insertado ninguna pelicula");
        moviesResponse.add(movie);
        Mockito.when(moviesRepository.findAll()).thenReturn(moviesEntities);
        Assertions.assertEquals(moviesServiceImpl.readMovies().get(0).getTitle(),moviesResponse.get(0).getTitle());
    }

    @Test
    void readMoviesById() {
        MovieEntity movie = makeMovie();
        // Estamos mockeando, simulando que el metodo findById del repositorio devuelve lo que tiene que devolver
        Mockito.when(moviesRepository.findById(1)).thenReturn(Optional.of(movie));
        Assertions.assertEquals(moviesServiceImpl.findMoviesById(1).getId(),movie.getId());
    }

    @Test
    void readMoviesByIdNotPresent() {
        MovieEntity movie = makeMovie();
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setTitle("No existe la pelicula con id "+ movie.getId());
        // Estamos mockeando, simulando que el metodo findById del repositorio devuelve lo que tiene que devolver
        Mockito.when(moviesRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertEquals(moviesServiceImpl.findMoviesById(1).getTitle(),movieResponse.getTitle());
    }

    @Test
    void findMoviesByName() {
        List<MovieEntity> moviesEntities = new ArrayList<>();
        List<MovieResponse> moviesResponse = new ArrayList<>();
        moviesEntities.add(makeMovie());
        Mockito.when(moviesRepository.findByTitle("Star Wars")).thenReturn(moviesEntities);
        assertInstanceOf(moviesServiceImpl.findMoviesByName("Star Wars").getClass(),moviesResponse);
    }

    @Test
    void findMoviesByNameNotPresent() {
        List<MovieEntity> moviesEntities = new ArrayList<>();
        List<MovieResponse> moviesResponse = new ArrayList<>();
        MovieResponse movie = new MovieResponse();
        movie.setTitle("No existe la pelicula de titulo "+ movie.getTitle());
        moviesResponse.add(movie);
        Mockito.when(moviesRepository.findByTitle("Titanic")).thenReturn(moviesEntities);
        assertInstanceOf(moviesServiceImpl.findMoviesByName("Titanic").getClass(),moviesResponse);
    }

    @Test
    void findMoviesByText() {
        List<MovieEntity> moviesEntities = new ArrayList<>();
        List<MovieResponse> moviesResponse = new ArrayList<>();
        moviesEntities.add(makeMovie());
        Mockito.when(moviesRepository.findAll()).thenReturn(moviesEntities);
        assertInstanceOf(moviesServiceImpl.findMoviesByText("star").getClass(),moviesResponse);
    }

    @Test
    void findMoviesByTextNotPresent() {
        List<MovieEntity> moviesEntities = new ArrayList<>();
        List<MovieResponse> moviesResponse = new ArrayList<>();
        moviesEntities.add(makeMovie());
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setTitle("No existe ninguna pelicula buscando el termino: titanic");
        moviesResponse.add(movieResponse);
        Mockito.when(moviesRepository.findAll()).thenReturn(moviesEntities);
        Assertions.assertEquals(moviesServiceImpl.findMoviesByText("titanic").get(0).getTitle(),moviesResponse.get(0).getTitle());
    }

    public MovieEntity makeMovie(){
        MovieEntity movie = new MovieEntity();
        movie.setId(1);
        movie.setTitle("Star Wars");
        movie.setYear(2021);
        movie.setGender("CienciaFicción");
        movie.setActors("Harrison Ford, y otros");
        movie.setNumOscar(2);
        return movie;
    }
}