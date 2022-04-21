package com.movies.controller;

import com.movies.model.MovieDTO;
import com.movies.model.MovieResponse;
import com.movies.services.MoviesServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController   //@RestController there is no need to do explicit json conversion.
                    // Just return a POJO and jackson serializer will take care of converting to json.
                    // It is equivalent to using @ResponseBody when used with @Controller.
                    // Rather than placing @ResponseBody on every controller method we place @RestController instead of vanilla @Controller and @ResponseBody by default is applied on all resources in that controller.
@Validated        //https://www.yawintutor.com/how-to-validate-request-body-in-spring-boot/
@RequestMapping("/peliculas")
public class MoviesController {

    @Autowired

    private MoviesServiceImpl moviesServicioImpl;

    @Operation(summary = "Ver peliculas", description = "Sin parametros muestra un listado de todas las peliculas de la base de datos, o busca por titulo, " +
            "id, o un texto determinado en cualquier campo de la pelicula ", method = "GET")
    @GetMapping(value="/listar")
    public ResponseEntity<List<MovieResponse>> readMovies(){
       List<MovieResponse> peliculas = moviesServicioImpl.readMovies();
        return new ResponseEntity<List<MovieResponse>>(peliculas, HttpStatus.OK);
    }

    @Operation(summary = "Buscar pelicula por id", description = "Busca una pelicula por su id", method = "GET")
    @GetMapping(value="/buscarPorId/{id}")
    public ResponseEntity<MovieResponse> findMoviesById(@PathVariable("id") int id){
        MovieResponse movieResponse = moviesServicioImpl.findMoviesById(id);
        return new ResponseEntity<MovieResponse>(movieResponse, HttpStatus.OK);
    }

    @Operation(summary = "Insertar película", description = "Inserta una pelicula en la base de datos", method = "POST")
    @PostMapping(value="/insertar")
    public ResponseEntity<MovieResponse> addMovie (@Valid @RequestBody MovieDTO movieDTOInsertar){
        MovieResponse movieResponse = moviesServicioImpl.addMovie(movieDTOInsertar);
        return ResponseEntity.ok(movieResponse);
    }

    @Operation(summary = "Buscar pelicula por titulo", description = "Busca una pelicula por su titulo", method = "GET")
    @GetMapping(value="/buscarPorTitulo/{titulo}")
    public ResponseEntity<List<MovieResponse>> findMoviesByName(@PathVariable("titulo") String titulo){
        List<MovieResponse> peliculas = moviesServicioImpl.findMoviesByName(titulo);
        return new ResponseEntity<List<MovieResponse>>(peliculas, HttpStatus.OK);
    }

    @Operation(summary = "Buscar por texto en cualquier campo", description = "Busca un texto en cualquier campo de la pelicula", method = "GET")
    @GetMapping(value="/buscarPorTexto/{texto}")
    public ResponseEntity<List<MovieResponse>> findMoviesByText(@PathVariable("texto") String texto){
        List<MovieResponse> peliculas = moviesServicioImpl.findMoviesByText(texto);
        return new ResponseEntity<List<MovieResponse>>(peliculas, HttpStatus.OK);
    }

}




