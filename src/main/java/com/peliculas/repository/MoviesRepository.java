package com.peliculas.repository;


import com.peliculas.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviesRepository extends JpaRepository<MovieEntity, Integer> {

    List<MovieEntity> findByTitulo(String titulo);

}
