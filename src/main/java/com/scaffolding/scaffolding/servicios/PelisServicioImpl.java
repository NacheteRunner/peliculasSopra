package com.scaffolding.scaffolding.servicios;

import com.scaffolding.scaffolding.modelo.PeliculaDTO;
import com.scaffolding.scaffolding.modelo.PeliculaEntity;
import com.scaffolding.scaffolding.modelo.PeliculaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.scaffolding.scaffolding.repositorios.PelisRepositorio;

import java.util.*;

@Service("PelisServicioImpl")
public class PelisServicioImpl implements PelisServicio {
    @Autowired

    private PelisRepositorio pelisRepositorio;

    // METODO INSERTAR
    public PeliculaResponse addPelicula (PeliculaDTO peliculaDTO) {
        PeliculaEntity peliculaEntity = convertDTOToEntity(peliculaDTO);
        pelisRepositorio.save(peliculaEntity);
        PeliculaResponse peliculaResponse = convertEntityToResponse(peliculaEntity);
        return peliculaResponse;
    }

    // LISTAR PELICULAS
    public List<PeliculaResponse> listarPeliculas(){
        List<PeliculaEntity> peliculasEntities = pelisRepositorio.findAll();
        List<PeliculaResponse> peliculasResponse = new ArrayList<>();
        if (!peliculasEntities.isEmpty()){
            for (PeliculaEntity peli: peliculasEntities) {
                PeliculaResponse peliculaResponse = convertEntityToResponse(peli);
                peliculasResponse.add(peliculaResponse);
            }
        }else{
            String error = "Todavia no se ha insertado ninguna pelicula";
            System.out.println(error);
            PeliculaResponse peliculaResponse = new PeliculaResponse();
            peliculaResponse.setTitulo(error);
            peliculasResponse.add(peliculaResponse);

        }
        return peliculasResponse;
    }

    // BUSCAR POR ID
    public PeliculaResponse listarPeliculaPorId(int id) {
        Optional<PeliculaEntity> peliculaEntityOptional = pelisRepositorio.findById(id);
        PeliculaResponse peliculaResponse;
        if(peliculaEntityOptional.isPresent()) {
            PeliculaEntity peliculaEntity = peliculaEntityOptional.get();
            peliculaResponse = convertEntityToResponse(peliculaEntity);
        }else{
            String error = "No existe la pelicula con id "+ id;
            System.out.println(error);
            peliculaResponse = new PeliculaResponse();
            peliculaResponse.setTitulo(error);
        }
        return peliculaResponse;
    }

    // BUSCAR POR NOMBRE
    public List<PeliculaResponse> findPeliculaByName (String titulo) {
        List<PeliculaEntity> peliculasEntities = pelisRepositorio.findByTitulo(titulo);
        List<PeliculaResponse> peliculasResponse = new ArrayList<>();
        if (!peliculasEntities.isEmpty()){
            for (PeliculaEntity peli: peliculasEntities) {
                PeliculaResponse peliculaResponse = convertEntityToResponse(peli);
                peliculasResponse.add(peliculaResponse);
            }


        }else{
            String error = "No existe la pelicula de titulo "+ titulo;
            System.out.println(error);
            PeliculaResponse peliculaResponse = new PeliculaResponse();
            peliculaResponse.setTitulo(error);
            peliculasResponse.add(peliculaResponse);

        }
        return peliculasResponse;
    }

    // BUSCAR POR TERMINO EN CUALQUIER CAMPO
    public List<PeliculaResponse> findPeliculaByTexto (String texto){
        List<PeliculaEntity> encontradas = new ArrayList<>();
        List<PeliculaEntity> peliculaEntities = pelisRepositorio.findAll();
        List<PeliculaResponse> peliculasResponse = new ArrayList<>();
        String patron = texto.toLowerCase();
            for (PeliculaEntity peli : peliculaEntities) {
                if(peli.getTitulo().toLowerCase().contains(patron)||
                        peli.getActores().toLowerCase().contains(patron)||
                        peli.getGenero().toLowerCase().contains(patron)||
                        String.valueOf(peli.getAnno()).equalsIgnoreCase(patron)){
                    encontradas.add(peli);
                }

            }
        if (!encontradas.isEmpty()){
            for (PeliculaEntity peli: encontradas) {
                PeliculaResponse peliculaResponse = convertEntityToResponse(peli);
                peliculasResponse.add(peliculaResponse);
            }
        }else{
            String error = "No existe ninguna pelicula buscando el termino:  "+ texto;
            System.out.println(error);
            PeliculaResponse peliculaResponse = new PeliculaResponse();
            peliculaResponse.setTitulo(error);
            peliculasResponse.add(peliculaResponse);

        }
        return peliculasResponse;
    }

    public PeliculaResponse convertEntityToResponse(PeliculaEntity peliculaEntity){
        PeliculaResponse peliculaResponse = new PeliculaResponse();
        peliculaResponse.setId(peliculaEntity.getId());
        peliculaResponse.setTitulo(peliculaEntity.getTitulo());
        peliculaResponse.setGenero(peliculaEntity.getGenero());
        peliculaResponse.setAnno(peliculaEntity.getAnno());
        peliculaResponse.setNum_oscar(peliculaEntity.getNum_oscar());
        peliculaResponse.setActores(peliculaEntity.getActores());
        return peliculaResponse;
    }

    public PeliculaEntity convertDTOToEntity(PeliculaDTO peliculaDTO){
        PeliculaEntity PeliculaEntity = new PeliculaEntity();
        PeliculaEntity.setId(peliculaDTO.getId());
        PeliculaEntity.setTitulo(peliculaDTO.getTitulo());
        PeliculaEntity.setGenero(peliculaDTO.getGenero());
        PeliculaEntity.setAnno(peliculaDTO.getAnno());
        PeliculaEntity.setNum_oscar(peliculaDTO.getNum_oscar());
        PeliculaEntity.setActores(peliculaDTO.getActores());
        return PeliculaEntity;
    }



}

