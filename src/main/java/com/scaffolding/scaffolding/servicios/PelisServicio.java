package com.scaffolding.scaffolding.servicios;

import com.scaffolding.scaffolding.modelo.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scaffolding.scaffolding.repositorios.PelisRepositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service("PelisServicio")
public class PelisServicio {
    @Autowired

    private PelisRepositorio pelisRepositorio;

    // METODO INSERTAR
    public void addPelicula (Pelicula pelicula) {
        pelisRepositorio.save(pelicula);
    }

    // LISTAR PELICULAS
    public List<Pelicula> listarPeliculas(){
        return pelisRepositorio.findAll();
    }

    // BUSCAR POR ID
    public Optional<Pelicula> listarPeliculaPorId(int id) { return pelisRepositorio.findById(id); }

    // BUSCAR POR NOMBRE
    public List<Pelicula> findPeliculaByName (String titulo) {
        return pelisRepositorio.findByTitulo(titulo);
    }

    // BUSCAR POR TERMINO EN CUALQUIER CAMPO
    public List<Pelicula> findPeliculaByTexto (String texto){
        List<Pelicula> peliculas = listarPeliculas();
        String patron = "%"+texto+"%";
        for (Pelicula peli : peliculas) {


        }
        return peliculas;
    }



}

