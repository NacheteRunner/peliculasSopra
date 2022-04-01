package com.scaffolding.scaffolding.repositorios;


import com.scaffolding.scaffolding.modelo.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PelisRepositorio extends JpaRepository<Pelicula, Integer> {

    List<Pelicula> findByTitulo(String titulo);

}
