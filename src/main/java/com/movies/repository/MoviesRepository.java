package com.movies.repository;


import com.movies.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviesRepository extends JpaRepository<MovieEntity, Integer> {

    List<MovieEntity> findByTitle(String title);

}
