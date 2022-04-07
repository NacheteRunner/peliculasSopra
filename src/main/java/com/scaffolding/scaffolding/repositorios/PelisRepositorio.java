package com.scaffolding.scaffolding.repositorios;


import com.scaffolding.scaffolding.modelo.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PelisRepositorio extends JpaRepository<PeliculaEntity, Integer> {

    List<PeliculaEntity> findByTitulo(String titulo);

}
