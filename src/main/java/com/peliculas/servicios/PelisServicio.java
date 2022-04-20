package com.peliculas.servicios;

import com.peliculas.modelo.PeliculaDTO;
import com.peliculas.modelo.PeliculaResponse;

import java.util.List;

public interface PelisServicio {

    public PeliculaResponse addPelicula (PeliculaDTO peliculaDTO);
    public List<PeliculaResponse> listarPeliculas();
    public PeliculaResponse listarPeliculaPorId(int id);
    public List<PeliculaResponse> findPeliculaByName (String titulo);
    public List<PeliculaResponse> findPeliculaByTexto (String texto);
}
