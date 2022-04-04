package com.scaffolding.scaffolding.controlador;

import com.scaffolding.scaffolding.modelo.Pelicula;
import com.scaffolding.scaffolding.repositorios.PelisRepositorio;
import com.scaffolding.scaffolding.servicios.PelisServicio;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class PelisControllerTest {

    @Mock
    private PelisServicio pelisServicio;

    @InjectMocks
    private PelisController pelisController;

    @Test
    void listarPeliculas() {
        List<Pelicula> peliculas= new ArrayList<Pelicula>();
        Mockito.when(pelisServicio.listarPeliculas()).thenReturn(peliculas);
        assertEquals(pelisController.listarPeliculas(), "Todavia no se ha insertado ninguna pelicula");
    }
    // test para cuando ya hay peliculas insertadas
    @Test
    void listarPeliculas2() {
        List<Pelicula> peliculas= new ArrayList<Pelicula>();
        Mockito.when(pelisServicio.listarPeliculas()).thenReturn(peliculas);
        assertEquals(pelisController.listarPeliculas(), peliculas);

    }

    @Test
    void consultarPorId() {
    }

    @Test
    void insertarPelicula() {
    }

    @Test
    void consultarPorNombre() {
    }
}