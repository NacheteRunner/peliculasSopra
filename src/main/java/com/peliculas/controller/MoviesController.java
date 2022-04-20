package com.peliculas.controller;

import com.peliculas.model.MovieDTO;
import com.peliculas.model.MovieResponse;
import com.peliculas.services.MoviesServiceImpl;

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

    private MoviesServiceImpl pelisServicioImpl;

    @Operation(summary = "Ver peliculas", description = "Sin parametros muestra un listado de todas las peliculas de la base de datos, o busca por titulo, " +
            "id, o un texto determinado en cualquier campo de la pelicula ", method = "GET")
    @GetMapping(value="/listar")
    public ResponseEntity<List<MovieResponse>> readMovies(){
       List<MovieResponse> peliculas = pelisServicioImpl.readMovies();
        return new ResponseEntity<List<MovieResponse>>(peliculas, HttpStatus.OK);
    }

    @GetMapping(value="/buscarPorId/{id}")
    public ResponseEntity<MovieResponse> findMoviesById(@PathVariable("id") int id){
        MovieResponse movieResponse = pelisServicioImpl.findMoviesById(id);
        return new ResponseEntity<MovieResponse>(movieResponse, HttpStatus.OK);
    }

    @Operation(summary = "Insertar película", description = "Inserta una pelicula en la base de datos", method = "POST")
    @PostMapping(value="/insertar")
    public ResponseEntity<MovieResponse> addMovie (@Valid @RequestBody MovieDTO movieDTOInsertar){
        MovieResponse movieResponse = pelisServicioImpl.addMovie(movieDTOInsertar);
        return ResponseEntity.ok(movieResponse);
    }

    @GetMapping(value="/buscarPorTitulo/{titulo}")
    public ResponseEntity<List<MovieResponse>> findMoviesByName(@PathVariable("titulo") String titulo){
        List<MovieResponse> peliculas = pelisServicioImpl.findMoviesByName(titulo);
        return new ResponseEntity<List<MovieResponse>>(peliculas, HttpStatus.OK);
    }

    @GetMapping(value="/buscarPorTexto/{texto}")
    public ResponseEntity<List<MovieResponse>> findMoviesByText(@PathVariable("texto") String texto){
        List<MovieResponse> peliculas = pelisServicioImpl.findMoviesByText(texto);
        return new ResponseEntity<List<MovieResponse>>(peliculas, HttpStatus.OK);
    }

}




