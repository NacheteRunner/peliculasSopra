package com.peliculas.services;

import com.peliculas.model.MovieDTO;
import com.peliculas.model.MovieResponse;
import com.peliculas.model.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.peliculas.repository.MoviesRepository;

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
            for (MovieEntity peli: moviesEntities) {
                MovieResponse movieResponse = convertEntityToResponse(peli);
                moviesResponse.add(movieResponse);
            }
        }else{
            String error = "Todavia no se ha insertado ninguna pelicula";
            System.out.println(error);
            MovieResponse movieResponse = new MovieResponse();
            movieResponse.setTitulo(error);
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
            movieResponse.setTitulo(error);
        }
        return movieResponse;
    }

    // BUSCAR POR NOMBRE
    public List<MovieResponse> findMoviesByName (String titulo) {
        List<MovieEntity> moviesEntities = moviesRepository.findByTitulo(titulo);
        List<MovieResponse> moviesResponse = new ArrayList<>();
        if (!moviesEntities.isEmpty()){
            for (MovieEntity peli: moviesEntities) {
                MovieResponse movieResponse = convertEntityToResponse(peli);
                moviesResponse.add(movieResponse);
            }


        }else{
            String error = "No existe la pelicula de titulo "+ titulo;
            System.out.println(error);
            MovieResponse movieResponse = new MovieResponse();
            movieResponse.setTitulo(error);
            moviesResponse.add(movieResponse);

        }
        return moviesResponse;
    }

    // BUSCAR POR TERMINO EN CUALQUIER CAMPO
    public List<MovieResponse> findMoviesByText (String texto){
        List<MovieEntity> encontradas = new ArrayList<>();
        List<MovieEntity> moviesEntities = moviesRepository.findAll();
        List<MovieResponse> moviesResponse = new ArrayList<>();
        String patron = texto.toLowerCase();
            for (MovieEntity peli : moviesEntities) {
                if(peli.getTitulo().toLowerCase().contains(patron)||
                        peli.getActores().toLowerCase().contains(patron)||
                        peli.getGenero().toLowerCase().contains(patron)||
                        String.valueOf(peli.getAnno()).equalsIgnoreCase(patron)){
                    encontradas.add(peli);
                }

            }
        if (!encontradas.isEmpty()){
            for (MovieEntity peli: encontradas) {
                MovieResponse movieResponse = convertEntityToResponse(peli);
                moviesResponse.add(movieResponse);
            }
        }else{
            String error = "No existe ninguna pelicula buscando el termino: "+ texto;
            System.out.println(error);
            MovieResponse movieResponse = new MovieResponse();
            movieResponse.setTitulo(error);
            moviesResponse.add(movieResponse);

        }
        return moviesResponse;
    }

    public MovieResponse convertEntityToResponse(MovieEntity movieEntity){
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(movieEntity.getId());
        movieResponse.setTitulo(movieEntity.getTitulo());
        movieResponse.setGenero(movieEntity.getGenero());
        movieResponse.setAnno(movieEntity.getAnno());
        movieResponse.setnumOscar(movieEntity.getnumOscar());
        movieResponse.setActores(movieEntity.getActores());
        return movieResponse;
    }

    public MovieEntity convertDTOToEntity(MovieDTO movieDTO){
        MovieEntity MovieEntity = new MovieEntity();
        MovieEntity.setTitulo(movieDTO.getTitulo());
        MovieEntity.setGenero(movieDTO.getGenero());
        MovieEntity.setAnno(movieDTO.getAnno());
        MovieEntity.setnumOscar(movieDTO.getnumOscar());
        MovieEntity.setActores(movieDTO.getActores());
        return MovieEntity;
    }



}

