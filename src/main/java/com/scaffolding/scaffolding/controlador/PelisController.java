package com.scaffolding.scaffolding.controlador;

import com.scaffolding.scaffolding.modelo.Pelicula;
import com.scaffolding.scaffolding.servicios.PelisServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController   //@RestController there is no need to do explicit json conversion.
                    // Just return a POJO and jackson serializer will take care of converting to json.
                    // It is equivalent to using @ResponseBody when used with @Controller.
                    // Rather than placing @ResponseBody on every controller method we place @RestController instead of vanilla @Controller and @ResponseBody by default is applied on all resources in that controller.

public class PelisController {

    @Autowired

    private PelisServicio pelisServicio;


    @RequestMapping(value="/listarPeliculas",method= RequestMethod.GET)
    public Object listarPeliculas(){
        List<Pelicula> peliculas = pelisServicio.listarPeliculas();
        if (!peliculas.isEmpty()){
            return peliculas;
        }else{
            String error = "Todavia no se ha insertado ninguna pelicula";
            System.out.println(error);
            return error;
        }

        // return new ResponseEntity<List<Pelicula>>(pelisServicio.listarPeliculas(), HttpStatus.OK);
    }



    @RequestMapping(value="/listarPeliculas",params = "id", method= RequestMethod.GET)
    public Object consultarPorId(@RequestParam("id")int id){
        Optional<Pelicula> pelicula = pelisServicio.listarPeliculaPorId(id);
        if(pelicula.isPresent()){
            return new ResponseEntity<>(pelicula, HttpStatus.OK);
        }
        else{
            String error = "No exisste la pelicula con id "+ id;
            System.out.println(error);
            return error;

        }
    }

    @RequestMapping(value="/insertarPelicula",method= RequestMethod.POST)
    public ResponseEntity<Object> insertarPelicula (@RequestBody Pelicula peliculaAInsertar){
        pelisServicio.addPelicula(peliculaAInsertar);
        String correcto = "La pelicula ha sido insertada correctamente";
        return new ResponseEntity<Object> (correcto, HttpStatus.OK);


    }

    @RequestMapping(value="/listarPeliculas", params = "titulo", method= RequestMethod.GET)
    public Object consultarPorNombre(@RequestParam("titulo")String titulo){

            List<Pelicula> peliculasBusqueda = pelisServicio.findPeliculaByName(titulo);
            if(!peliculasBusqueda.isEmpty()){

                return new ResponseEntity<List<Pelicula>>(peliculasBusqueda, HttpStatus.OK);

            }else{
                String error = "No exisste la pelicula de titulo "+ titulo;
                System.out.println(error);
                return error;
            }



    }
    @RequestMapping(value="/listarPeliculas", params = "texto", method= RequestMethod.GET)
    public Object consultarPorTexto(@RequestParam("texto")String texto){

        List<Pelicula> peliculasBusqueda = pelisServicio.findPeliculaByTexto(texto);
        if(!peliculasBusqueda.isEmpty()){

            return new ResponseEntity<List<Pelicula>>(peliculasBusqueda, HttpStatus.OK);

        }else{
            String error = "No existe ninguna pelicula buscando el termino:  "+ texto;
            System.out.println(error);
            return error;
        }



    }

}




