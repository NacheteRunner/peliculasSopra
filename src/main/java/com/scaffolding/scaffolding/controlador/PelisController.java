package com.scaffolding.scaffolding.controlador;

import com.scaffolding.scaffolding.modelo.PeliculaDTO;
import com.scaffolding.scaffolding.modelo.PeliculaEntity;
import com.scaffolding.scaffolding.modelo.PeliculaResponse;
import com.scaffolding.scaffolding.servicios.PelisServicioImpl;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController   //@RestController there is no need to do explicit json conversion.
                    // Just return a POJO and jackson serializer will take care of converting to json.
                    // It is equivalent to using @ResponseBody when used with @Controller.
                    // Rather than placing @ResponseBody on every controller method we place @RestController instead of vanilla @Controller and @ResponseBody by default is applied on all resources in that controller.
@RequestMapping("/")
public class PelisController {

    @Autowired

    private PelisServicioImpl pelisServicioImpl;

    @Operation(summary = "Ver peliculas", description = "Sin parametros muestra un listado de todas las peliculas de la base de datos, o busca por titulo, " +
            "id, o un texto determinado en cualquier campo de la pelicula ", method = "GET")
    @GetMapping(value="listarPeliculas")
    public ResponseEntity<List<PeliculaResponse>> listarPeliculas(){
       List<PeliculaResponse> peliculas = pelisServicioImpl.listarPeliculas();
        return new ResponseEntity<List<PeliculaResponse>>(peliculas, HttpStatus.OK);
    }

    @RequestMapping(value="listarPeliculas",params = "id", method= RequestMethod.GET)
    public ResponseEntity<PeliculaResponse> consultarPorId(@RequestParam(required = false)int id){
        PeliculaResponse peliculaResponse = pelisServicioImpl.listarPeliculaPorId(id);
        return new ResponseEntity<PeliculaResponse>(peliculaResponse, HttpStatus.OK);
    }

    @Operation(summary = "Insertar película", description = "Inserta una pelicula en la base de datos", method = "POST")
    @RequestMapping(value="insertarPelicula",method= RequestMethod.POST)
    public ResponseEntity<PeliculaResponse> insertarPelicula (@RequestBody PeliculaDTO peliculaDTOInsertar){
        PeliculaResponse peliculaResponse= pelisServicioImpl.addPelicula(peliculaDTOInsertar);
        return new ResponseEntity<PeliculaResponse> (peliculaResponse, HttpStatus.OK);
    }

    @RequestMapping(value="/listarPeliculas", params = "titulo", method= RequestMethod.GET)
    public ResponseEntity<List<PeliculaResponse>> consultarPorNombre(@RequestParam(required = false)String titulo){
        List<PeliculaResponse> peliculas = pelisServicioImpl.findPeliculaByName(titulo);
        return new ResponseEntity<List<PeliculaResponse>>(peliculas, HttpStatus.OK);
    }

    @RequestMapping(value="/listarPeliculas", params = "texto", method= RequestMethod.GET)
    public ResponseEntity<List<PeliculaResponse>> consultarPorTexto(@RequestParam(required = false)String texto){
        List<PeliculaResponse> peliculas = pelisServicioImpl.findPeliculaByTexto(texto);
        return new ResponseEntity<List<PeliculaResponse>>(peliculas, HttpStatus.OK);
    }

}




