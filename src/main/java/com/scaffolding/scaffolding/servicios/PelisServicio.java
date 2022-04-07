package com.scaffolding.scaffolding.servicios;

import com.scaffolding.scaffolding.modelo.PeliculaDTO;
import com.scaffolding.scaffolding.modelo.PeliculaEntity;
import com.scaffolding.scaffolding.modelo.PeliculaResponse;

import java.util.List;
import java.util.Optional;

public interface PelisServicio {

    public PeliculaResponse addPelicula (PeliculaDTO peliculaDTO);
    public List<PeliculaResponse> listarPeliculas();
    public PeliculaResponse listarPeliculaPorId(int id);
    public List<PeliculaResponse> findPeliculaByName (String titulo);
    public List<PeliculaResponse> findPeliculaByTexto (String texto);
}
