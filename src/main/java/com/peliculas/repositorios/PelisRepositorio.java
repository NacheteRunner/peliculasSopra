package com.peliculas.repositorios;


import com.peliculas.modelo.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PelisRepositorio extends JpaRepository<PeliculaEntity, Integer> {

    List<PeliculaEntity> findByTitulo(String titulo);

}
