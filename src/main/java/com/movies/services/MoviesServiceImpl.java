package com.movies.services;

import com.movies.model.MovieDTO;
import com.movies.model.MovieResponse;
import com.movies.model.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movies.repository.MoviesRepository;

import java.util.*;

@Service("MoviesServiceImpl")
public class MoviesServiceImpl implements MoviesService {

    @Autowired

    private MoviesRepository moviesRepository;

    // METODO INSERTAR
    public MovieResponse addMovie (MovieDTO movieDTO) {
        MovieEntity movieEntity = convertDTOToEntity(movieDTO);
        movieEntity = moviesRepository.save(movieEntity);  //Cambio Oriol
        MovieResponse movieResponse = convertEntityToResponse(movieEntity);
        return movieResponse;
    }

    // LISTAR PELICULAS
    public List<MovieResponse> readMovies(){
        List<MovieEntity> moviesEntities = moviesRepository.findAll();
        List<MovieResponse> moviesResponse = new ArrayList<>();
        if (!moviesEntities.isEmpty()){
            for (MovieEntity movie: moviesEntities) {
                MovieResponse movieResponse = convertEntityToResponse(movie);
                moviesResponse.add(movieResponse);
            }
        }else{
            String error = "Todavia no se ha insertado ninguna pelicula";
            System.out.println(error);
            MovieResponse movieResponse = new MovieResponse();
            movieResponse.setTitle(error);
            moviesResponse.add(movieResponse);

        }
        return moviesResponse;
    }

    // BUSCAR POR ID
    public MovieResponse findMoviesById(int id) {
        Optional<MovieEntity> movieEntityOptional = moviesRepository.findById(id);
        MovieResponse movieResponse;
        if(movieEntityOptional.isPresent()) {
            MovieEntity movieEntity = movieEntityOptional.get();
            movieResponse = convertEntityToResponse(movieEntity);
        }else{
            String error = "No existe la pelicula con id "+ id;
            System.out.println(error);
            movieResponse = new MovieResponse();
            movieResponse.setTitle(error);
        }
        return movieResponse;
    }

    // BUSCAR POR NOMBRE
    public List<MovieResponse> findMoviesByName (String titulo) {
        List<MovieEntity> moviesEntities = moviesRepository.findByTitle(titulo);
        List<MovieResponse> moviesResponse = new ArrayList<>();
        if (!moviesEntities.isEmpty()){
            for (MovieEntity movie: moviesEntities) {
                MovieResponse movieResponse = convertEntityToResponse(movie);
                moviesResponse.add(movieResponse);
            }


        }else{
            String error = "No existe la pelicula de titulo "+ titulo;
            System.out.println(error);
            MovieResponse movieResponse = new MovieResponse();
            movieResponse.setTitle(error);
            moviesResponse.add(movieResponse);

        }
        return moviesResponse;
    }

    // BUSCAR POR TERMINO EN CUALQUIER CAMPO
    public List<MovieResponse> findMoviesByText (String texto){
        List<MovieEntity> foundMovies = new ArrayList<>();
        List<MovieEntity> moviesEntities = moviesRepository.findAll();
        List<MovieResponse> moviesResponse = new ArrayList<>();
        String patron = texto.toLowerCase();
            for (MovieEntity movie : moviesEntities) {
                if(movie.getTitle().toLowerCase().contains(patron)||
                        movie.getActors().toLowerCase().contains(patron)||
                        movie.getGender().toLowerCase().contains(patron)||
                        String.valueOf(movie.getYear()).equalsIgnoreCase(patron)){
                    foundMovies.add(movie);
                }

            }
        if (!foundMovies.isEmpty()){
            for (MovieEntity movie: foundMovies) {
                MovieResponse movieResponse = convertEntityToResponse(movie);
                moviesResponse.add(movieResponse);
            }
        }else{
            String error = "No existe ninguna pelicula buscando el termino: "+ texto;
            System.out.println(error);
            MovieResponse movieResponse = new MovieResponse();
            movieResponse.setTitle(error);
            moviesResponse.add(movieResponse);

        }
        return moviesResponse;
    }

    public MovieResponse convertEntityToResponse(MovieEntity movieEntity){
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(movieEntity.getId());
        movieResponse.setTitle(movieEntity.getTitle());
        movieResponse.setGender(movieEntity.getGender());
        movieResponse.setYear(movieEntity.getYear());
        movieResponse.setNumOscar(movieEntity.getNumOscar());
        movieResponse.setActors(movieEntity.getActors());
        return movieResponse;
    }

    public MovieEntity convertDTOToEntity(MovieDTO movieDTO){
        MovieEntity MovieEntity = new MovieEntity();
        MovieEntity.setTitle(movieDTO.getTitle());
        MovieEntity.setGender(movieDTO.getGender());
        MovieEntity.setYear(movieDTO.getYear());
        MovieEntity.setNumOscar(movieDTO.getNumOscar());
        MovieEntity.setActors(movieDTO.getActors());
        return MovieEntity;
    }



}

