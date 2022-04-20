package com.peliculas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peliculas.model.MovieDTO;
import com.peliculas.services.MoviesServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MoviesController.class)

class MoviesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    @Qualifier("MoviesServiceImpl")
    private MoviesServiceImpl moviesServiceImpl;

    @Test
    void readMovies() throws Exception {
        mockMvc.perform(get("/peliculas/listar")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void findMoviesById() throws Exception {
        mockMvc.perform(get("/peliculas/buscarPorId/1")
                .contentType("application/json"))
                .andExpect(status().isOk());

    }

    @Test
    void addMovie() throws Exception {
        mockMvc.perform(post("/peliculas/insertar")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(makeMovie())))
                .andExpect(status().isOk());

    }

    @Test
    void findMoviesByName() throws Exception {
        mockMvc.perform(get("/peliculas/buscarPorTitulo/Star wars")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void findMoviesByText() throws Exception {
        mockMvc.perform(get("/peliculas/buscarPorTexto/Ciencia-Ficción")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    public MovieDTO makeMovie(){
        MovieDTO movie = new MovieDTO();
        movie.setTitulo("Star Wars");
        movie.setAnno(2021);
        movie.setGenero("CienciaFicción");
        movie.setActores("Harrison Ford, y otros");
        movie.setNum_oscar(2);
        return movie;
    }


}