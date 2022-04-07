package com.scaffolding.scaffolding.servicios;

import com.scaffolding.scaffolding.modelo.PeliculaEntity;
import com.scaffolding.scaffolding.repositorios.PelisRepositorio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PelisServicioImplTest {

    /*@Mock
    private PelisRepositorio pelisRepositorio;

    @InjectMocks
    private PelisServicioImpl pelisServicioImpl;

    @Test
    void addPelicula() {

    }

    @Test
    void listarPeliculas() {
        List<PeliculaEntity> peliculaEntities = new ArrayList<>();
        Mockito.when(pelisRepositorio.findAll()).thenReturn(peliculaEntities);
        assertInstanceOf(pelisServicioImpl.listarPeliculas().getClass(), peliculaEntities);
    }

    @Test
    void listarPeliculaPorId() {
        PeliculaEntity peliculaEntity = new PeliculaEntity();
        // Estamos mockeando, simulando que el metodo findById del repositorio devuelve lo que tiene que devolver
        Mockito.when(pelisRepositorio.findById(1)).thenReturn(Optional.of(peliculaEntity));
        assertEquals(pelisServicioImpl.listarPeliculaPorId(1).get().getId(), peliculaEntity.getId());
    }

    @Test
    void findPeliculaByName() {
        List<PeliculaEntity> peliculaEntities = new ArrayList<>();
        //Mockito.when(pelisRepositorio.findByTitulo("Dune")).thenReturn(peliculas);
        assertEquals(pelisServicioImpl.listarPeliculas(), peliculaEntities);
    }

    @Test
    void findPeliculaByTexto() {
    }*/
}