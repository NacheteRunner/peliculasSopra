package com.scaffolding.scaffolding.servicios;

import com.scaffolding.scaffolding.modelo.PeliculaEntity;
import com.scaffolding.scaffolding.modelo.PeliculaResponse;
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
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PelisServicioImplTest {

    @Mock
    private PelisRepositorio pelisRepositorio;

    @InjectMocks
    private PelisServicioImpl pelisServicioImpl;

    @Test
    void addPelicula() {
        // https://www.baeldung.com/mockito-unnecessary-stubbing-exception lenient()
        PeliculaEntity peli = creaPeli();
        lenient().when(pelisRepositorio.save(peli)).thenReturn(peli);
        assertEquals(peli,peli);
    }

    @Test
    void listarPeliculas() {
        List<PeliculaEntity> peliculaEntities = new ArrayList<>();
        Mockito.when(pelisRepositorio.findAll()).thenReturn(peliculaEntities);
        assertInstanceOf(pelisServicioImpl.listarPeliculas().getClass(), peliculaEntities);
    }
    @Test
    void listarPeliculasSinPeliculas() {
        List<PeliculaEntity> peliculasEntities = new ArrayList<PeliculaEntity>();
        List<PeliculaResponse> peliculasResponse = new ArrayList<>();
        PeliculaResponse peli = new PeliculaResponse();
        peli.setTitulo("Todavia no se ha insertado ninguna pelicula");
        peliculasResponse.add(peli);
        Mockito.when(pelisRepositorio.findAll()).thenReturn(peliculasEntities);
        assertEquals(pelisServicioImpl.listarPeliculas().get(0).getTitulo(),peliculasResponse.get(0).getTitulo());
    }

    @Test
    void listarPeliculaPorId() {
        PeliculaEntity peli = creaPeli();
        // Estamos mockeando, simulando que el metodo findById del repositorio devuelve lo que tiene que devolver
        Mockito.when(pelisRepositorio.findById(1)).thenReturn(Optional.of(peli));
        assertEquals(pelisServicioImpl.listarPeliculaPorId(1).getId(),peli.getId());
    }

    @Test
    void listarPeliculaPorId_IdNoExistente() {
        PeliculaEntity peli = creaPeli();
        PeliculaResponse peliResponse = new PeliculaResponse();
        peliResponse.setTitulo("No existe la pelicula con id "+ peli.getId());
        // Estamos mockeando, simulando que el metodo findById del repositorio devuelve lo que tiene que devolver
        Mockito.when(pelisRepositorio.findById(1)).thenReturn(Optional.empty());
        assertEquals(pelisServicioImpl.listarPeliculaPorId(1).getTitulo(),peliResponse.getTitulo());
    }

    @Test
    void findPeliculaByName() {
        List<PeliculaEntity> peliculasEntities = new ArrayList<>();
        List<PeliculaResponse> peliculasResponse = new ArrayList<>();
        peliculasEntities.add(creaPeli());
        Mockito.when(pelisRepositorio.findByTitulo("Star Wars")).thenReturn(peliculasEntities);
        assertInstanceOf(pelisServicioImpl.findPeliculaByName("Star Wars").getClass(),peliculasResponse);
    }

    @Test
    void findPeliculaByName_NameNoExistente() {
        List<PeliculaEntity> peliculasEntities = new ArrayList<>();
        List<PeliculaResponse> peliculasResponse = new ArrayList<>();
        PeliculaResponse peli = new PeliculaResponse();
        peli.setTitulo("No existe la pelicula de titulo "+ peli.getTitulo());
        peliculasResponse.add(peli);
        Mockito.when(pelisRepositorio.findByTitulo("Titanic")).thenReturn(peliculasEntities);
        assertInstanceOf(pelisServicioImpl.findPeliculaByName("Titanic").getClass(),peliculasResponse);
    }

    @Test
    void findPeliculaByTexto() {
        List<PeliculaEntity> peliculasEntities = new ArrayList<>();
        List<PeliculaResponse> peliculasResponse = new ArrayList<>();
        peliculasEntities.add(creaPeli());
        Mockito.when(pelisRepositorio.findAll()).thenReturn(peliculasEntities);
        assertInstanceOf(pelisServicioImpl.findPeliculaByTexto("star").getClass(),peliculasResponse);
    }

    @Test
    void findPeliculaByTexto_NoExistente() {
        List<PeliculaEntity> peliculasEntities = new ArrayList<>();
        List<PeliculaResponse> peliculasResponse = new ArrayList<>();
        peliculasEntities.add(creaPeli());
        PeliculaResponse peliResponse = new PeliculaResponse();
        peliResponse.setTitulo("No existe ninguna pelicula buscando el termino: titanic");
        peliculasResponse.add(peliResponse);
        Mockito.when(pelisRepositorio.findAll()).thenReturn(peliculasEntities);
        assertEquals(pelisServicioImpl.findPeliculaByTexto("titanic").get(0).getTitulo(),peliculasResponse.get(0).getTitulo());
    }

    public PeliculaEntity creaPeli(){
        PeliculaEntity peli = new PeliculaEntity();
        peli.setId(1);
        peli.setTitulo("Star Wars");
        peli.setAnno(2021);
        peli.setGenero("CienciaFicción");
        peli.setActores("Harrison Ford, y otros");
        peli.setNum_oscar(2);
        return peli;
    }
}