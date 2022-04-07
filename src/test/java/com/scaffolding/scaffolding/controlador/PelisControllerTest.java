package com.scaffolding.scaffolding.controlador;

import com.scaffolding.scaffolding.modelo.PeliculaEntity;
import com.scaffolding.scaffolding.servicios.PelisServicioImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class PelisControllerTest {

    /*@Mock
    private PelisServicioImpl pelisServicioImpl;

    @InjectMocks
    private PelisController pelisController;

    @Test
    void listarPeliculas() {
        List<PeliculaEntity> peliculaEntities = new ArrayList<PeliculaEntity>();
        Mockito.when(pelisServicioImpl.listarPeliculas()).thenReturn(peliculaEntities);
        assertEquals(pelisController.listarPeliculas(), "Todavia no se ha insertado ninguna pelicula");
    }
    // test para cuando ya hay peliculas insertadas
    @Test
    void listarPeliculas2() {
        List<PeliculaEntity> peliculaEntities = new ArrayList<PeliculaEntity>();
        Mockito.when(pelisServicioImpl.listarPeliculas()).thenReturn(peliculaEntities);
        assertEquals(pelisController.listarPeliculas(), peliculaEntities);

    }

    @Test
    void consultarPorId() {
    }

    @Test
    void insertarPelicula() {
    }

    @Test
    void consultarPorNombre() {
    }*/
}