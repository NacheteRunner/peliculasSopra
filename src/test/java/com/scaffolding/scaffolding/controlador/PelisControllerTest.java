package com.scaffolding.scaffolding.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaffolding.scaffolding.modelo.PeliculaDTO;
import com.scaffolding.scaffolding.modelo.PeliculaEntity;
import com.scaffolding.scaffolding.modelo.PeliculaResponse;
import com.scaffolding.scaffolding.servicios.PelisServicioImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PelisController.class)

class PelisControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    @Qualifier("PelisServicioImpl")
    private PelisServicioImpl pelisServicioImpl;

    @Test
    void listarPeliculas() throws Exception {
        mockMvc.perform(get("/listarPeliculas")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void consultarPorId() throws Exception {
        mockMvc.perform(get("/listarPeliculas")
                .contentType("application/json").param("id","1"))
                .andExpect(status().isOk());

    }

    @Test
    void insertarPelicula() throws Exception {
        mockMvc.perform(post("/insertarPelicula")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(creaPeli())))
                .andExpect(status().isOk());

    }

    @Test
    void consultarPorNombre() throws Exception {
        mockMvc.perform(get("/listarPeliculas")
                        .contentType("application/json").param("titulo","Star wars"))
                .andExpect(status().isOk());
    }

    @Test
    void consultarPorTexto() throws Exception {
        mockMvc.perform(get("/listarPeliculas")
                        .contentType("application/json").param("texto","Ciencia-Ficción"))
                .andExpect(status().isOk());
    }

    public PeliculaDTO creaPeli(){
        PeliculaDTO peli = new PeliculaDTO();
        peli.setTitulo("Star Wars");
        peli.setAnno(2021);
        peli.setGenero("CienciaFicción");
        peli.setActores("Harrison Ford, y otros");
        peli.setNum_oscar(2);
        return peli;
    }


}