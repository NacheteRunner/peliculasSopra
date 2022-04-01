package com.scaffolding.scaffolding.servicios;

import com.scaffolding.scaffolding.modelo.Pelicula;
import com.scaffolding.scaffolding.repositorios.PelisRepositorio;
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
@ExtendWith(MockitoExtension.class)
class PelisServicioTest {

    @Mock
    private PelisRepositorio pelisRepositorio;

    @InjectMocks
    private PelisServicio pelisServicio;

    @Test
    void addPelicula() {

    }

    @Test
    void listarPeliculas() {
    }

    @Test
    void listarPeliculaPorId() {
        Pelicula pelicula = new Pelicula();
        // Estamos mockeando, simulando que el metodo findById del repositorio devuelve lo que tiene que devolver
        Mockito.when(pelisRepositorio.findById(1)).thenReturn(Optional.of(pelicula));
        assertEquals(pelisServicio.listarPeliculaPorId(1).get().getId(), pelicula.getId());
    }

    @Test
    void findPeliculaByName() {
        List<Pelicula> peliculas = new ArrayList<>();
        //Mockito.when(pelisRepositorio.findByTitulo("Dune")).thenReturn(peliculas);
        assertEquals(pelisServicio.listarPeliculas(), peliculas);
    }

    @Test
    void findPeliculaByTexto() {
    }
}